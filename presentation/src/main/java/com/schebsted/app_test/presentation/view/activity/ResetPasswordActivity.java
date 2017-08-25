package com.schebsted.app_test.presentation.view.activity;

import android.os.Bundle;

import com.schebsted.app_test.presentation.R;
import com.schebsted.app_test.presentation.view.activity.base.CleanActivity;
import com.schebsted.app_test.presentation.view.fragment.ResetPasswordFragment;

public class ResetPasswordActivity extends CleanActivity {

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new ResetPasswordFragment());
        }
    }

    @Override
    protected boolean useToolbar() {
        return false;
    }

}
