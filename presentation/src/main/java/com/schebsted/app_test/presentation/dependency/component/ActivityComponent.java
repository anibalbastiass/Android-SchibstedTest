package com.schebsted.app_test.presentation.dependency.component;

import com.schebsted.app_test.presentation.dependency.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
public interface ActivityComponent extends FragmentInjector {}
