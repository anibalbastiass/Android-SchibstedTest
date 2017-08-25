package com.schebsted.app_test.presentation.view.activity;

import com.schebsted.app_test.data.net.RestApi;
import com.schebsted.app_test.presentation.view.activity.base.WebViewActivity;

public class PrivacyActivity extends WebViewActivity {

    private static final String TERMS_URL = RestApi.URL_BASE + "/privacy";

    @Override
    public String getUrl() {
        return TERMS_URL;
    }

}
