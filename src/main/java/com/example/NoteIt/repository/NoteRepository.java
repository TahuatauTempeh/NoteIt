package com.example.NoteIt.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.NoteIt.model.Note;

public interface NoteRepository extends JpaRepository<Note, UUID>{
    // methods

    // all notes from one user
    List<Note> findByUserId(UUID userId);

    // all notes from one user, soonest deadline first
    List<Note> findByUserIdOrderByDeadlineAsc(UUID userId);

    // all notes in one category from one user
    List<Note> findByUserIdAndCategoryId(UUID userId, UUID categoryId);

    // all notes from one user that have no category
    List<Note> findByUserIdAndCategoryIsNull(UUID userId);

    // all notes from one user that are not finished yet
    List<Note> findByUserIdAndCompletedFalse(UUID userId);

    // all notes from one user that are not finished and whose deadline already passed (overdue)
    List<Note> findByUserIdAndCompletedFalseAndDeadlineBefore(UUID userId, LocalDateTime now);

    // search the notes of one user by title
    List<Note> findByUserIdAndTitleContainingIgnoreCase(UUID userId, String keyword);

    // all notes in a category, when that category gets deleted
    List<Note> findByCategoryId(UUID categoryId);

    // one note from a user
    Optional<Note> findByIdAndUserId(UUID id, UUID userId);

    // removes the category from all notes in it in one query (call this before deleting a category)
    @Modifying(clearAutomatically = true)
    @Query("update Note n set n.category = null where n.category.id = :categoryId")
    void clearCategory(@Param("categoryId") UUID categoryId);

}