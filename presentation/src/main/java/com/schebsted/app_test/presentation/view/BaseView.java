package com.schebsted.app_test.presentation.view;

import android.content.Context;

public interface BaseView {

    Context context();

    void showLoader();
    void hideLoader();
    void handleError(Throwable error);
    void showMessage(String message);

    void close();
    void closeAndDisplayLogin();
}
