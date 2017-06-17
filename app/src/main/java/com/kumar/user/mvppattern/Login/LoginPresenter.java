package com.kumar.user.mvppattern.Login;

/**
 * Created by User on 6/16/2017.
 */

public interface LoginPresenter {
    void validCred(String username,String password);
    void onDestroy();
}
