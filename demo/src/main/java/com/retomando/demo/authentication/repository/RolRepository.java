package com.retomando.demo.authentication.repository;



import com.retomando.demo.authentication.entity.Rol;
import com.retomando.demo.authentication.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, String> {
    Optional<Rol>findByRolName(Roles roles);
}
