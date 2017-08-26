package com.schebsted.app_test.data.repository;

import android.content.SharedPreferences;

import com.schebsted.app_test.domain.entity.ArtistEntity;
import com.schebsted.app_test.domain.repository.SessionRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SessionDataRepository implements SessionRepository {

    private static final String EMAIL = "email";
    private static final String AUTH_TOKEN = "auth_token";
    private static final String ARTISTS_REALM = "artists_realm";

    private final SharedPreferences sharedPreferences;

    @Inject
    public SessionDataRepository(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public ArtistEntity getCurrentArtist() {
        if (sharedPreferences.contains(ARTISTS_REALM)) {
            ArtistEntity artist = new ArtistEntity(sharedPreferences.getString(ARTISTS_REALM, null));
            return artist;
        }
        return new ArtistEntity();
    }

    @Override
    public void setCurrentArtists(ArtistEntity user) {
        // TODO: Save to Realm
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ARTISTS_REALM, user.getResults().toArray().toString());
        editor.apply();
    }

    @Override
    public void invalidateSession() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(EMAIL);
        editor.remove(AUTH_TOKEN);
        editor.apply();
    }
}
