package com.schebsted.app_test.domain.interactor;

import com.schebsted.app_test.domain.entity.VersionEntity;
import com.schebsted.app_test.domain.executor.PostExecutionThread;
import com.schebsted.app_test.domain.executor.ThreadExecutor;
import com.schebsted.app_test.domain.repository.SessionRepository;
import com.schebsted.app_test.domain.repository.VersionRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CheckVersionExpirationUseCase extends UseCase<VersionEntity> {

    private VersionRepository versionRepository;
    private SessionRepository sessionRepository;

    @Inject
    public CheckVersionExpirationUseCase(ThreadExecutor threadExecutor,
                                         PostExecutionThread postExecutionThread,
                                         VersionRepository versionRepository,
                                         SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.versionRepository = versionRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    protected Observable<VersionEntity> buildUseCaseObservable() {
        return this.versionRepository
                                .checkVersionExpiration(this.sessionRepository.getCurrentUser());
    }
}
