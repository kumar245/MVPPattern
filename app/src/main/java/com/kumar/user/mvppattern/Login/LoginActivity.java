package com.kumar.user.mvppattern.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kumar.user.mvppattern.MainActivity;
import com.kumar.user.mvppattern.R;

/**
 * Created by User on 6/16/2017.
 */

public class LoginActivity extends AppCompatActivity implements LoginView{

    private EditText edUserName,edPassword;
    private Button button;
    private ProgressBar progressBar;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mLoginPresenter=new LoginPresenterImpl(this);
        edUserName= (EditText) findViewById(R.id.userName);
        edPassword= (EditText) findViewById(R.id.passWord);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.validCred(edUserName.getText().toString().trim(),edPassword.getText().toString().trim());
            }
        });

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void setUserNameError() {
        edUserName.setError("UserName is Empty");
    }

    @Override
    public void setPasswordError() {
        edPassword.setError("Password is Empty");

    }

    @Override
    public void navigatetoMain() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();
    }
}
