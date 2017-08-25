package com.schebsted.app_test.domain.repository;

import com.schebsted.app_test.domain.entity.UserEntity;

public interface SessionRepository {
    UserEntity getCurrentUser();
    void setCurrentUser(UserEntity user);
    void invalidateSession();
}
