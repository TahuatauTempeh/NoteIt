package com.example.NoteIt.model;

import java.util.UUID;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// this is just to store the image link datas

@Entity 
@Table(name = "note_images")

public class NoteImage {
    // attributes

    // image id's
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    // note's id
    @ManyToOne 
    @JoinColumn(name = "note_id", nullable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Note note;

    // storage path for the image
    @Column(nullable = false, length = 1000)
    private String storage_path;

    // type of image content
    @Column(nullable = false, length = 100)
    private String content_type;

    // methods
    public NoteImage() {
    }

    public NoteImage(String content_type, Note note, String storage_path) {
        this.content_type = content_type;
        this.note = note;
        this.storage_path = storage_path;
    }

    public UUID getId() {
        return id;
    }

    public Note getNote() {
        return note;
    }

    public String getStorage_path() {
        return storage_path;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setStorage_path(String storage_path) {
        this.storage_path = storage_path;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    
}
