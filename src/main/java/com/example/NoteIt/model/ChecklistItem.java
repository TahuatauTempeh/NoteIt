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

@Entity 
@Table(name = "checklist_items")

public class ChecklistItem {
    // attributes

    // check list items id
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // note_id
    @ManyToOne
    @JoinColumn(name = "note_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Note note;

    // text
    @Column(nullable = false, length = 500)
    private String text;

    // a done checker box
    @Column(nullable = false)
    private boolean done;

    // position of the item in the checklist
    @Column(nullable = false)
    private int position;

    // methods
    public ChecklistItem() {
    }

    public ChecklistItem(boolean done, Note note, int position, String text) {
        this.done = done;
        this.note = note;
        this.position = position;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public Note getNote() {
        return note;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return done;
    }

    public int getPosition() {
        return position;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    



}
