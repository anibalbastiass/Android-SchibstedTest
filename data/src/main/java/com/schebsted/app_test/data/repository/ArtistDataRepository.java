/*
 * Copyright (c) 2017. Build by anibalbastias
 */

package com.schebsted.app_test.data.repository;

import android.util.Log;

import com.schebsted.app_test.data.net.RestApi;
import com.schebsted.app_test.domain.entity.ArtistEntity;
import com.schebsted.app_test.domain.repository.ArtistRepository;


import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class ArtistDataRepository extends RestApiRepository implements ArtistRepository {

    private final RestApi restApi;

    @Inject
    public ArtistDataRepository(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<ArtistEntity> searchArtist(String artist_name) {
        return this.restApi.searchArtists(artist_name)
                .map(artistEntityResponse -> {
                    handleResponseError(artistEntityResponse);
                    return artistEntityResponse.body();
                });
    }
}
