package com.retomando.demo.authentication.repository;


import com.retomando.demo.authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String userName);
    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findByTokenPassword(String tokenPassword);


    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    
}
