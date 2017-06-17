package com.kumar.user.mvppattern.Login;

/**
 * Created by User on 6/16/2017.
 */

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUserNameError();
    void setPasswordError();
    void navigatetoMain();
    void showAlert(String message);

}
