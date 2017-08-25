package com.schebsted.app_test.domain.repository;

import com.schebsted.app_test.domain.entity.NoteEntity;
import com.schebsted.app_test.domain.entity.UserEntity;
import com.schebsted.app_test.domain.entity.VoidEntity;

import java.util.List;

import io.reactivex.Observable;

public interface NoteRepository {
    Observable<NoteEntity> createNote(UserEntity user, NoteEntity note);
    Observable<NoteEntity> getNote(UserEntity user, int noteId);
    Observable<List<NoteEntity>> getNotes(UserEntity user);
    Observable<NoteEntity> updateNote(UserEntity user, NoteEntity note);
    Observable<VoidEntity> deleteNote(UserEntity user, int noteId);
}
