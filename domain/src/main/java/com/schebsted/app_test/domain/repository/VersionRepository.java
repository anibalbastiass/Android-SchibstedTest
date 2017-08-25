package com.schebsted.app_test.domain.repository;

import com.schebsted.app_test.domain.entity.UserEntity;
import com.schebsted.app_test.domain.entity.VersionEntity;

import io.reactivex.Observable;

public interface VersionRepository {
    Observable<VersionEntity> checkVersionExpiration(UserEntity user);
}
