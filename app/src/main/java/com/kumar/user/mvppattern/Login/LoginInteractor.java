package com.kumar.user.mvppattern.Login;

/**
 * Created by User on 6/16/2017.
 */

public interface LoginInteractor {
    interface  onLoginFinishedListener{
        void onUserNameError();
        void onPasswordError();
        void onSuccess();
        void onFailure(String message);
    }
    void login(String userName,String password,onLoginFinishedListener listener);
}
