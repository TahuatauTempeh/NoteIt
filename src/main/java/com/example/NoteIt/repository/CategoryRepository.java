package com.example.NoteIt.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.NoteIt.model.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID>{
    // methods

    // lists all the categories of one user
    List<Category> findByUserId(UUID userId);

    // one category that that user has
    Optional<Category> findByIdAndUserId(UUID id, UUID userId);

    // check if a user has made a category with the same name lol
    Optional<Category> existsByUserIdAndNameIgnoreCase(UUID userId, String name);

}
