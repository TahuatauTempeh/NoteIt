package com.example.NoteIt.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.NoteIt.model.NoteImage;

public interface NoteImageRepository extends JpaRepository<NoteImage, UUID>{
    // methods

    // all images of one note
    List<NoteImage> findByNoteId(UUID noteId);

    // one image, but only if its note belongs to that user
    Optional<NoteImage> findByIdAndNoteUserId(UUID id, UUID userId);

    // how many images a note has (to limit the number of pictures per note)
    long countByNoteId(UUID noteId);

}