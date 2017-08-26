/*
 * Copyright (c) 2017. Build by anibalbastias
 */

package com.schebsted.app_test.data.net.wrapper;

import com.schebsted.app_test.domain.entity.ArtistEntity;

public class ArtistWrapper {

    private ArtistEntity artist;

    public ArtistWrapper(ArtistEntity artist) {
        this.artist = artist;
    }

    public ArtistEntity getArtist() {
        return artist;
    }

    public void setUser(ArtistEntity artist) {
        this.artist = artist;
    }
}
