package com.retomando.demo.authentication.auth.service;

import com.retomando.demo.authentication.entity.Rol;
import com.retomando.demo.authentication.enums.Roles;
import com.retomando.demo.authentication.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolName(Roles rolName){
        return rolRepository.findByRolName(rolName);
    }
    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
