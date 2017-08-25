package com.schebsted.app_test.domain.interactor.note;

import com.schebsted.app_test.domain.entity.NoteEntity;
import com.schebsted.app_test.domain.executor.PostExecutionThread;
import com.schebsted.app_test.domain.executor.ThreadExecutor;
import com.schebsted.app_test.domain.interactor.UseCase;
import com.schebsted.app_test.domain.repository.NoteRepository;
import com.schebsted.app_test.domain.repository.SessionRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CreateNoteUseCase extends UseCase<NoteEntity> {

    private NoteRepository noteRepository;
    private SessionRepository sessionRepository;

    private NoteEntity note;

    @Inject
    public CreateNoteUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                             NoteRepository noteRepository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.noteRepository = noteRepository;
        this.sessionRepository = sessionRepository;
    }

    public void setParams(NoteEntity note) {
        this.note = note;
    }

    @Override
    protected Observable<NoteEntity> buildUseCaseObservable() {
        return this.noteRepository.createNote(this.sessionRepository.getCurrentUser(), this.note);
    }
}
