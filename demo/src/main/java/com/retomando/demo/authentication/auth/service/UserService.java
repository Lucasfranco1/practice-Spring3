package com.retomando.demo.authentication.auth.service;

import com.retomando.demo.authentication.auth.dto.JwtDTO;
import com.retomando.demo.authentication.auth.dto.LoginUserDTO;
import com.retomando.demo.authentication.auth.dto.MessageDTO;
import com.retomando.demo.authentication.auth.dto.NewUserDTO;
import com.retomando.demo.authentication.auth.jwt.JwtProvider;
import com.retomando.demo.authentication.entity.Rol;
import com.retomando.demo.authentication.entity.User;
import com.retomando.demo.authentication.enums.Roles;
import com.retomando.demo.authentication.exceptions.CustomException;
import com.retomando.demo.authentication.exceptions.ParamBadRequest;
import com.retomando.demo.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    public Optional<User> getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Optional<User> getByUserNameOrEmail(String usernameOrEmail){
        return userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
    }

    public Optional<User> getByTokenPassword(String tokenPassword){
        return userRepository.findByTokenPassword(tokenPassword);
    }

    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public JwtDTO login(LoginUserDTO loginUser) {

        System.out.println("En login "+ loginUser.getUsername());
        System.out.println("contraseña"+loginUser.getPassword());
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        System.out.println("jwt"+ jwt);
        return new JwtDTO(jwt);
    }

    public JwtDTO refresh(JwtDTO jwtDto) throws ParseException {
        String token = jwtProvider.refreshToken(jwtDto);
        return new JwtDTO(token);
    }

    public MessageDTO save(NewUserDTO newUser){
        if(userRepository.existsByUsername(newUser.getUsername()))
            throw new CustomException(HttpStatus.BAD_REQUEST, "ese nombre de usuario ya existe");
        if(userRepository.existsByEmail(newUser.getEmail()))
            throw new CustomException(HttpStatus.BAD_REQUEST, "ese email de usuario ya existe");
        User user =
                new User(newUser.getName(), newUser.getUsername(), newUser.getEmail(),
                        passwordEncoder.encode(newUser.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(Roles.ROLE_USER).get());
        if(newUser.getRoles().contains("admin"))
            roles.add(rolService.getByRolName(Roles.ROLE_ADMIN).get());
        user.setRoles(roles);
        userRepository.save(user);
        return new MessageDTO(user.getUsername() + " ha sido creado");
    }
}
