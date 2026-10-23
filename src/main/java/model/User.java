package model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

//so that the thing detects it as a table in the database
@Entity
@Table(name = "users")

public class User {
//    attrivutes
//    user id
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private Long id;

//    username
    @Column(nullable = false, unique = true, length = 50)
    private String username;

//    email
    @Column(nullable = false, unique = true, length = 255)
    private String email;

//    password_hash
    @Column(nullable = false)
    private String password_hash;

//    when the account was created
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

//    methods

//    empty constructor
    public User() {
    }

//    constructor
//    these are the values that the users are allowed to input
    public User(String username, String email, String password_hash) {
        this.username = username;
        this.email = email;
        this.password_hash = password_hash;
    }

//    automatically assign this to the current time that is used
    @PrePersist
    protected void onCreate() {
        this.created_at = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }
}
