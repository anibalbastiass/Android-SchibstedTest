package com.schebsted.app_test.data.net;

import com.schebsted.app_test.data.net.wrapper.UserWrapper;
import com.schebsted.app_test.domain.entity.ArtistEntity;
import com.schebsted.app_test.domain.entity.MessageEntity;
import com.schebsted.app_test.domain.entity.NoteEntity;
import com.schebsted.app_test.domain.entity.UserEntity;
import com.schebsted.app_test.domain.entity.VersionEntity;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import io.reactivex.Observable;
import retrofit2.http.Query;

public interface RestApi {

    String URL_BASE = "https://itunes.apple.com";

    @GET("/search")
    Observable<Response<ArtistEntity>> searchArtists(@Query("term") String artist_name);

    @POST("/users")
    Observable<Response<UserEntity>> createUser(@Body UserWrapper userWrapper);

    @DELETE("/users/0")
    Observable<Response<Void>> deleteUser(@Header("Authorization") String token);

    @POST("/users/reset_password")
    Observable<Response<MessageEntity>> resetPassword(@Header("Authorization") String token,
                                                      @Body UserWrapper userWrapper);

    @POST("/users/login")
    Observable<Response<UserEntity>> doLogin(@Body UserWrapper userWrapper);

    @DELETE("/users/logout")
    Observable<Response<Void>> doLogout(@Header("Authorization") String token);

    @GET("/versions/state")
    Observable<Response<VersionEntity>> checkVersionExpiration(
                                                            @Header("Authorization") String token);

    @POST("/notes")
    Observable<Response<NoteEntity>> createNote(@Header("Authorization") String token,
                                                @Body NoteEntity note);

    @GET("/notes/{id}")
    Observable<Response<NoteEntity>> getNote(@Header("Authorization") String token,
                                             @Path("id") int noteId);

    @GET("/notes")
    Observable<Response<List<NoteEntity>>> getNotes(@Header("Authorization") String token);

    @PUT("/notes/{id}")
    Observable<Response<NoteEntity>> updateNote(@Header("Authorization") String token,
                                                @Path("id") int noteId, @Body NoteEntity note);

    @DELETE("/notes/{id}")
    Observable<Response<Void>> deleteNote(@Header("Authorization") String token,
                                          @Path("id") int noteId);

}
