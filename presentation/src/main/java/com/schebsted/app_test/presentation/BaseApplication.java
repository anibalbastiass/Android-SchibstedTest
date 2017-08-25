package com.schebsted.app_test.presentation;

import android.app.Application;

import com.schebsted.app_test.presentation.dependency.component.ApplicationComponent;
import com.schebsted.app_test.presentation.dependency.component.DaggerActivityComponent;
import com.schebsted.app_test.presentation.dependency.component.DaggerApplicationComponent;
import com.schebsted.app_test.presentation.dependency.component.FragmentInjector;
import com.schebsted.app_test.presentation.dependency.module.ApplicationModule;

public class BaseApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    protected void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                                        .applicationModule(new ApplicationModule(this))
                                        .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    public FragmentInjector getFragmentInjector() {
        return DaggerActivityComponent.builder()
                .applicationComponent(this.applicationComponent).build();
    }

}
