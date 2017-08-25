package com.schebsted.app_test.domain.interactor.note;

import com.schebsted.app_test.domain.entity.VoidEntity;
import com.schebsted.app_test.domain.executor.PostExecutionThread;
import com.schebsted.app_test.domain.executor.ThreadExecutor;
import com.schebsted.app_test.domain.interactor.UseCase;
import com.schebsted.app_test.domain.repository.NoteRepository;
import com.schebsted.app_test.domain.repository.SessionRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DeleteNoteUseCase extends UseCase<VoidEntity> {

    private NoteRepository noteRepository;
    private SessionRepository sessionRepository;

    private int noteId;

    @Inject
    public DeleteNoteUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                             NoteRepository noteRepository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.noteRepository = noteRepository;
        this.sessionRepository = sessionRepository;
    }

    public void setParams(int noteId) {
        this.noteId = noteId;
    }

    @Override
    protected Observable<VoidEntity> buildUseCaseObservable() {
        return this.noteRepository.deleteNote(this.sessionRepository.getCurrentUser(), this.noteId);
    }
}
