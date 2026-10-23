package com.example.NoteIt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

//so that the thing detects it as a table in the database
@Entity
@Table(name = "users")

public class User {
//    attrivutes
//    user id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    username
    @Column(nullable = false, unique = true, length = 50)
    private String username;

//

//    methods
}
