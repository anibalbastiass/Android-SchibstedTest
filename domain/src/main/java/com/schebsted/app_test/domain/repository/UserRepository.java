package com.schebsted.app_test.domain.repository;

import com.schebsted.app_test.domain.entity.MessageEntity;
import com.schebsted.app_test.domain.entity.UserEntity;
import com.schebsted.app_test.domain.entity.VoidEntity;

import io.reactivex.Observable;

public interface UserRepository {
    Observable<UserEntity> createUser(UserEntity user);
    Observable<VoidEntity> deleteUser(UserEntity user);
    Observable<MessageEntity> resetPassword(UserEntity user);

    Observable<UserEntity> loginUser(UserEntity user);
    Observable<VoidEntity> logoutUser(UserEntity user);
}
