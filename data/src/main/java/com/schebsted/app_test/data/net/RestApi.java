package com.schebsted.app_test.data.net;

import com.schebsted.app_test.domain.entity.ArtistEntity;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {

    String URL_BASE = "https://itunes.apple.com";

    @GET("/search")
    Observable<Response<ArtistEntity>> searchArtists(@Query("term") String artist_name);
}
