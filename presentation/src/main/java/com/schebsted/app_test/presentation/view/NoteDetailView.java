package com.schebsted.app_test.presentation.view;

import com.schebsted.app_test.domain.entity.NoteEntity;

public interface NoteDetailView extends BaseView {

    void showNote(NoteEntity note);
    int getNoteId();

}
