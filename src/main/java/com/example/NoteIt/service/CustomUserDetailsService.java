package com.example.NoteIt.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.NoteIt.model.User;
import com.example.NoteIt.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    // attributes

    private final UserRepository userRepository;

    // methods

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // called by Spring Security when someone logs in
    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        String cleaned = identifier.trim();

        User user = userRepository.findByUsernameOrEmail(cleaned, cleaned.toLowerCase())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword_hash())
                .roles("USER")
                .build();
    }
}