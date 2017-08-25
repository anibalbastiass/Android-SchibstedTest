package com.schebsted.app_test.domain.interactor.user;

import com.schebsted.app_test.domain.entity.UserEntity;
import com.schebsted.app_test.domain.entity.VoidEntity;
import com.schebsted.app_test.domain.executor.PostExecutionThread;
import com.schebsted.app_test.domain.executor.ThreadExecutor;
import com.schebsted.app_test.domain.interactor.UseCase;
import com.schebsted.app_test.domain.repository.SessionRepository;
import com.schebsted.app_test.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DoLogoutUseCase extends UseCase<VoidEntity> {

    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    @Inject
    public DoLogoutUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                           UserRepository userRepository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    protected Observable<VoidEntity> buildUseCaseObservable() {
        UserEntity currentUser = this.sessionRepository.getCurrentUser();
        this.sessionRepository.invalidateSession();
        return this.userRepository.logoutUser(currentUser);
    }
}
