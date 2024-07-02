package com.retomando.demo.authentication.auth.util;

import com.retomando.demo.authentication.auth.service.RolService;
import com.retomando.demo.authentication.entity.Rol;
import com.retomando.demo.authentication.enums.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateRol implements CommandLineRunner {

    @Autowired
    RolService rolService;
    @Override
    public void run(String... args) throws Exception {
        /** Rol rolAdmin = new Rol(Roles.ROLE_ADMIN);
         Rol rolUser = new Rol(Roles.ROLE_USER);
         rolService.save(rolAdmin);
         rolService.save(rolUser);
         */

    }
}
