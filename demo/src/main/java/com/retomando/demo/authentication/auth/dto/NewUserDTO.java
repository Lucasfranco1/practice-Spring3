package com.retomando.demo.authentication.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

public class NewUserDTO {
    @NotBlank(message = "nombre obligatorio")
    private String name;
    @NotBlank(message = "nombre de usuario obligatorio")
    private String username;
    @Email(message = "dirección de email no válida")
    @NotBlank(message = "email obligatorio")
    private String email;
    @NotBlank
    private String password;
    private Set<String> roles = new HashSet<>();

    public @NotBlank(message = "nombre obligatorio") String getName() {
        return name;
    }

    public NewUserDTO setName(@NotBlank(message = "nombre obligatorio") String name) {
        this.name = name;
        return this;
    }

    public @NotBlank(message = "nombre de usuario obligatorio") String getUsername() {
        return username;
    }

    public NewUserDTO setUserName(@NotBlank(message = "nombre de usuario obligatorio") String username) {
        this.username = username;
        return this;
    }

    public @Email(message = "dirección de email no válida") @NotBlank(message = "email obligatorio") String getEmail() {
        return email;
    }

    public NewUserDTO setEmail(@Email(message = "dirección de email no válida") @NotBlank(message = "email obligatorio") String email) {
        this.email = email;
        return this;
    }

    public @NotBlank String getPassword() {
        return password;
    }

    public NewUserDTO setPassword(@NotBlank String password) {
        this.password = password;
        return this;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public NewUserDTO setRoles(Set<String> roles) {
        this.roles = roles;
        return this;
    }
}
