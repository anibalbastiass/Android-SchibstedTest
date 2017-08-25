package com.schebsted.app_test.presentation.dependency.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.schebsted.app_test.data.net.RestApi;
import com.schebsted.app_test.domain.executor.PostExecutionThread;
import com.schebsted.app_test.domain.executor.ThreadExecutor;
import com.schebsted.app_test.domain.repository.ArtistRepository;
import com.schebsted.app_test.domain.repository.NoteRepository;
import com.schebsted.app_test.domain.repository.SessionRepository;
import com.schebsted.app_test.domain.repository.UserRepository;
import com.schebsted.app_test.domain.repository.VersionRepository;
import com.schebsted.app_test.presentation.dependency.module.ApplicationModule;
import com.schebsted.app_test.presentation.dependency.module.DataModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, DataModule.class })
public interface ApplicationComponent {

    Context context();
    SharedPreferences sharedPreferences();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();

    SessionRepository sessionRepository();
    RestApi restApi();

    ArtistRepository artistRepository();

    UserRepository userRepository();
    NoteRepository noteRepository();
    VersionRepository versionRepository();

}
