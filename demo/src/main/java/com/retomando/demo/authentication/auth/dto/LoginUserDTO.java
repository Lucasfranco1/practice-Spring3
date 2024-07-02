package com.retomando.demo.authentication.auth.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginUserDTO {
    @NotBlank(message = "nombre de usuario/email obligatorio")
    private String username;
    @NotBlank(message = "contraseña obligatoria")
    private String password;

    public @NotBlank(message = "nombre de usuario/email obligatorio") String getUsername() {
        return username;
    }

    public LoginUserDTO setUsername(@NotBlank(message = "nombre de usuario/email obligatorio") String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
