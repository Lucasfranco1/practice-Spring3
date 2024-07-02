package com.retomando.demo.authentication.entity;


import com.retomando.demo.authentication.enums.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Rol {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    private String id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles rolName;

    public Rol() {
    }

    public Rol(@NotNull Roles rolName) {
        this.rolName = rolName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Roles getRolName() {
        return rolName;
    }

    public Rol setRolName(Roles rolName) {
        this.rolName = rolName;
        return this;
    }
}

