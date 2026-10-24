package com.example.NoteIt.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity 
@Table(name = "notes")

public class Note {
    // attributes

    // Note id
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // user id
    @ManyToOne 
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // category id
    @ManyToOne 
    @JoinColumn(name = "category_id", nullable = true) 
    private Category category;

    // title
    @Column(nullable = false, length = 100)
    private String title;

    // description
    @Column(nullable = true, length = 2000)
    private String description;

    // deadline
    @Column(nullable = true)
    private LocalDateTime deadline;

    // is_conmpleted
    @Column(nullable = false)
    private boolean completed;

    // created at
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    // methods

    public Note() {
    }

    public Note(User user, Category category, boolean completed, LocalDateTime deadline, String description, String title) {
        this.user = user;
        this.category = category;
        this.completed = completed;
        this.deadline = deadline;
        this.description = description;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // makes sure that the note has the data for when it was created
    @PrePersist 
    protected void onCreate() {
        this.created_at = LocalDateTime.now();
    }

    // check if a note is overdue
    public boolean isOverdue() {
        if (this.deadline != null && this.completed == false && this.deadline.isBefore(LocalDateTime.now())) {
            return true;
        }

        return false;
    }


}
