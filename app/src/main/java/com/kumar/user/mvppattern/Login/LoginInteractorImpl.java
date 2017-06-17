package com.kumar.user.mvppattern.Login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by User on 6/16/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(String userName, String password, final onLoginFinishedListener listener) {
        if (TextUtils.isEmpty(userName)){
            listener.onUserNameError();
        }
        else if (TextUtils.isEmpty(password)){
            listener.onPasswordError();

        }
        else if (userName.equals("admin") && password.equals("12345")){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    listener.onSuccess();
                }
            },3000);

        }
        else {
            listener.onFailure("Invalid credentials");
        }

    }
}
