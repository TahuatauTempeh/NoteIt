package com.example.NoteIt.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.NoteIt.model.ChecklistItem;

public interface ChecklistItemRepository extends JpaRepository<ChecklistItem, UUID>{
    // methods

    // all checklist items of one note, in order (first to last)
    List<ChecklistItem> findByNoteIdOrderByPositionAsc(UUID noteId);

    // all checklist items of one note, in reverse order (last to first)
    List<ChecklistItem> findByNoteIdOrderByPositionDesc(UUID noteId);

    // all checklist items of one user, sorted by the deadline of the note they belong to (soonest first)
    List<ChecklistItem> findByNoteUserIdOrderByNoteDeadlineAsc(UUID userId);

    // the last item of a note (to work out the position of the next item)
    Optional<ChecklistItem> findTopByNoteIdOrderByPositionDesc(UUID noteId);

    // one item, but only if its note belongs to that user
    Optional<ChecklistItem> findByIdAndNoteUserId(UUID id, UUID userId);

    // how many items a note has
    long countByNoteId(UUID noteId);

    // how many items of a note are ticked
    long countByNoteIdAndDoneTrue(UUID noteId);

}