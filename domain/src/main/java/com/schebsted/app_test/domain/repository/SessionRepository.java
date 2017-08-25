package com.schebsted.app_test.domain.repository;

import com.schebsted.app_test.domain.entity.ArtistEntity;
import com.schebsted.app_test.domain.entity.UserEntity;

public interface SessionRepository {
    UserEntity getCurrentUser();
    ArtistEntity getCurrentArtist();
    void setCurrentUser(UserEntity user);
    void setCurrentArtists(ArtistEntity user);
    void invalidateSession();
}
