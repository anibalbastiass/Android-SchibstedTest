package com.schebsted.app_test.domain.interactor.user;

import com.schebsted.app_test.domain.entity.UserEntity;
import com.schebsted.app_test.domain.executor.PostExecutionThread;
import com.schebsted.app_test.domain.executor.ThreadExecutor;
import com.schebsted.app_test.domain.interactor.UseCase;
import com.schebsted.app_test.domain.repository.SessionRepository;
import com.schebsted.app_test.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class DoLoginUseCase extends UseCase<UserEntity> {

    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    private UserEntity user;

    @Inject
    public DoLoginUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                          UserRepository userRepository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public void setParams(UserEntity user) {
        this.user = user;
    }

    @Override
    protected Observable<UserEntity> buildUseCaseObservable() {
        return this.userRepository.loginUser(this.user)
                .doOnNext(new Consumer<UserEntity>() {
                    @Override
                    public void accept(UserEntity userEntity) throws Exception {
                        sessionRepository.setCurrentUser(userEntity);
                    }
                });
    }
}
