package com.schebsted.app_test.domain.interactor.note;

import com.schebsted.app_test.domain.entity.NoteEntity;
import com.schebsted.app_test.domain.executor.PostExecutionThread;
import com.schebsted.app_test.domain.executor.ThreadExecutor;
import com.schebsted.app_test.domain.interactor.UseCase;
import com.schebsted.app_test.domain.repository.NoteRepository;
import com.schebsted.app_test.domain.repository.SessionRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetNotesUseCase extends UseCase<List<NoteEntity>> {

    private NoteRepository noteRepository;
    private SessionRepository sessionRepository;

    @Inject
    public GetNotesUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                           NoteRepository noteRepository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.noteRepository = noteRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    protected Observable<List<NoteEntity>> buildUseCaseObservable() {
        return this.noteRepository.getNotes(this.sessionRepository.getCurrentUser());
    }
}
