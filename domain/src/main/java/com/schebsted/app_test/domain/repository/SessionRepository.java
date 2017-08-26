package com.schebsted.app_test.domain.repository;

import com.schebsted.app_test.domain.entity.ArtistEntity;

public interface SessionRepository {
    ArtistEntity getCurrentArtist();
    void setCurrentArtists(ArtistEntity user);
    void invalidateSession();
}