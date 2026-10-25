package com.example.NoteIt.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.NoteIt.dto.RegisterRequest;
import com.example.NoteIt.exception.NotFoundException;
import com.example.NoteIt.model.User;
import com.example.NoteIt.repository.UserRepository;

@Service
public class UserService {
    // attributes

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // methods

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // creates a new account, or throws an error if the username or email is already used
    public User register(RegisterRequest request) {
        String username = request.getUsername().trim();
        String email = request.getEmail().trim().toLowerCase();

        if (userRepository.existsByUsernameIgnoreCase(username)) {
            throw new IllegalArgumentException("Username is already taken");
        }

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email is already registered");
        }

        String passwordHash = passwordEncoder.encode(request.getPassword());

        return userRepository.save(new User(username, email, passwordHash));
    }

    // finds the logged-in user by the username that Spring Security gives us
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}