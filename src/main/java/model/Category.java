package model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "category")

public class Category {
    // attributes

    // user id
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // user id foreign key
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) 
    private User user;

    // name of the category
    @Column(nullable = false, length = 255)
    private String name;

    // colour of the category
    @Column(nullable = true, length = 60)
    private String colour;

    // methods

    // empty constructor
    public Category() {
    }

    // constructors
    public Category(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

}
