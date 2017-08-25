package com.schebsted.app_test.presentation.presenter;

import com.schebsted.app_test.domain.entity.UserEntity;
import com.schebsted.app_test.domain.interactor.user.DoLoginUseCase;
import com.schebsted.app_test.presentation.dependency.ActivityScope;
import com.schebsted.app_test.presentation.view.BaseView;
import com.schebsted.app_test.presentation.view.LoginView;

import javax.inject.Inject;

@ActivityScope
public class LoginPresenter extends BasePresenter implements Presenter {

    private DoLoginUseCase doLoginUseCase;
    LoginView loginView;

    @Inject
    public LoginPresenter(DoLoginUseCase doLoginUseCase) {
        super(doLoginUseCase);
        this.doLoginUseCase = doLoginUseCase;
    }

    @Override
    public void initWithView(BaseView view) {
        super.initWithView(view);
        this.loginView = (LoginView) view;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.loginView = null;
    }

    public void loginUser(String email, String password) {
        UserEntity user = new UserEntity(email);
        user.setPassword(password);

        this.showLoader();
        this.doLoginUseCase.setParams(user);
        this.doLoginUseCase.execute(new LoginSubscriber());
    }

    protected class LoginSubscriber extends BaseSubscriber<UserEntity> {

        @Override
        public void onNext(UserEntity user) {
            LoginPresenter.this.hideLoader();
            LoginPresenter.this.loginView.viewNotes();
        }

    }

}
