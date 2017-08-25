package com.schebsted.app_test.data.repository;

import com.schebsted.app_test.data.net.RestApi;
import com.schebsted.app_test.domain.entity.UserEntity;
import com.schebsted.app_test.domain.entity.VersionEntity;
import com.schebsted.app_test.domain.repository.VersionRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class VersionDataRepository extends RestApiRepository implements VersionRepository {

    private final RestApi restApi;

    @Inject
    public VersionDataRepository(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<VersionEntity> checkVersionExpiration(UserEntity user) {
        return this.restApi.checkVersionExpiration(user.getAuthToken())
                .map(versionEntityResponse -> {
                    handleResponseError(versionEntityResponse);
                    return versionEntityResponse.body();
                });
    }

}
