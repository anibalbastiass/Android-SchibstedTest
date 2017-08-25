/*
 * Copyright (c) 2017. Build by anibalbastias
 */

package com.schebsted.app_test.domain.repository;

import com.schebsted.app_test.domain.entity.ArtistEntity;

import io.reactivex.Observable;

public interface ArtistRepository {
    Observable<ArtistEntity> searchArtist(String artist_name);
}
