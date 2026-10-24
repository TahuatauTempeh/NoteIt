package com.example.NoteIt.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.NoteIt.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    // methods
    
    // finding a user by their username
    Optional<User> findByUsername(String username);

    // finding a user by their email
    Optional<User> findByEmail(String email);

    // by either email or usrname
    Optional<User> findByUsernameOrEmail(String username, String email);

    // check if that user exists based on their username
    boolean existsByUsername(String username);

    // check if that user exists based on their email
    boolean existsByEmail(String email);
}
