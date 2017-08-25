package com.schebsted.app_test.domain.interactor.user;

import com.schebsted.app_test.domain.entity.MessageEntity;
import com.schebsted.app_test.domain.entity.UserEntity;
import com.schebsted.app_test.domain.executor.PostExecutionThread;
import com.schebsted.app_test.domain.executor.ThreadExecutor;
import com.schebsted.app_test.domain.interactor.UseCase;
import com.schebsted.app_test.domain.repository.SessionRepository;
import com.schebsted.app_test.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ResetPasswordUseCase extends UseCase<MessageEntity> {

    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    private UserEntity user;

    @Inject
    public ResetPasswordUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                                UserRepository userRepository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public void setParams(UserEntity user) {
        this.user = user;
    }

    @Override
    protected Observable<MessageEntity> buildUseCaseObservable() {
        if (this.user == null) this.user = sessionRepository.getCurrentUser();
        return this.userRepository.resetPassword(this.user);
    }
}
