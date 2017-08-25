package com.schebsted.app_test.presentation.presenter;

import com.schebsted.app_test.presentation.view.BaseView;

public interface Presenter {

    void initWithView(BaseView view);
    void resume();
    void pause();
    void destroy();

}
