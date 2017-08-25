package com.schebsted.app_test.presentation.view.activity.base;

import android.os.Bundle;

import com.schebsted.app_test.presentation.R;
import com.schebsted.app_test.presentation.view.fragment.WebViewFragment;

public abstract class WebViewActivity extends BaseActivity implements WebViewFragment.Listener {

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new WebViewFragment());
        }
    }

}
