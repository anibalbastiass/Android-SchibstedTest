package com.schebsted.app_test.presentation.dependency.module;

import android.content.SharedPreferences;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.schebsted.app_test.data.net.RestApi;
import com.schebsted.app_test.data.net.interceptor.HttpInterceptor;
import com.schebsted.app_test.data.repository.NoteDataRepository;
import com.schebsted.app_test.data.repository.SessionDataRepository;
import com.schebsted.app_test.data.repository.UserDataRepository;
import com.schebsted.app_test.data.repository.VersionDataRepository;
import com.schebsted.app_test.domain.repository.NoteRepository;
import com.schebsted.app_test.domain.repository.SessionRepository;
import com.schebsted.app_test.domain.repository.UserRepository;
import com.schebsted.app_test.domain.repository.VersionRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    @Provides
    @Singleton
    SessionRepository provideSessionRepository(SharedPreferences sharedPreferences) {
        return new SessionDataRepository(sharedPreferences);
    }

    @Provides
    @Singleton
    RestApi provideRestApi() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                                                .addInterceptor(new HttpInterceptor())
                                                .build();

        GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create());

        return new Retrofit.Builder()
                           .baseUrl(RestApi.URL_BASE)
                           .addConverterFactory(factory)
                           .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                           .client(client)
                           .build()
                           .create(RestApi.class);
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(RestApi restApi) {
        return new UserDataRepository(restApi);
    }

    @Provides
    @Singleton
    NoteRepository provideNoteRepository(RestApi restApi) {
        return new NoteDataRepository(restApi);
    }

    @Provides
    @Singleton
    VersionRepository provideVersionRepository(RestApi restApi) {
        return new VersionDataRepository(restApi);
    }

}
