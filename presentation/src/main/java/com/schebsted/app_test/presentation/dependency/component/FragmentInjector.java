package com.schebsted.app_test.presentation.dependency.component;

import com.schebsted.app_test.presentation.view.fragment.LoginFragment;
import com.schebsted.app_test.presentation.view.fragment.NoteCreateFragment;
import com.schebsted.app_test.presentation.view.fragment.NoteDetailFragment;
import com.schebsted.app_test.presentation.view.fragment.NoteEditFragment;
import com.schebsted.app_test.presentation.view.fragment.NotesFragment;
import com.schebsted.app_test.presentation.view.fragment.RegisterFragment;
import com.schebsted.app_test.presentation.view.fragment.ResetPasswordFragment;
import com.schebsted.app_test.presentation.view.fragment.SettingsFragment;

public interface FragmentInjector {

    void inject(LoginFragment loginFragment);
    void inject(RegisterFragment registerFragment);
    void inject(NotesFragment notesFragment);
    void inject(NoteDetailFragment noteDetailFragment);
    void inject(NoteCreateFragment noteCreateFragment);
    void inject(NoteEditFragment noteEditFragment);
    void inject(SettingsFragment settingsFragment);
    void inject(ResetPasswordFragment resetPasswordFragment);

}
