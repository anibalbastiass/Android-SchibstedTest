package com.schebsted.app_test.presentation.view;

import com.schebsted.app_test.domain.entity.NoteEntity;

import java.util.List;

public interface NotesView extends BaseView {

    void showNotes(List<NoteEntity> notes);
    void showNote(int noteId);
    void showExpirationWarning();

}
