package com.retomando.demo.authentication.auth.controller;


import com.retomando.demo.authentication.auth.dto.JwtDTO;
import com.retomando.demo.authentication.auth.dto.LoginUserDTO;
import com.retomando.demo.authentication.auth.dto.MessageDTO;
import com.retomando.demo.authentication.auth.dto.NewUserDTO;
import com.retomando.demo.authentication.auth.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
public class AuthController {

   @Autowired
   UserService userService;

    /*
    //SIGNUP
    Modification of the registration method so that it generates the token and there is an automatic login.
    Return jwt.
     */
    @PostMapping(value = "register", headers = "Accept=application/json")
    public ResponseEntity signup(@Valid @RequestBody NewUserDTO newUserDTO){
        return ResponseEntity.ok(userService.save(newUserDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUserDTO loginUserDTO){
        System.out.println("Entrando a login");
        return ResponseEntity.ok(userService.login(loginUserDTO));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtDTO> refresh(@RequestBody JwtDTO jwtDTO) throws ParseException {
        return ResponseEntity.ok(userService.refresh(jwtDTO));
    }

}
