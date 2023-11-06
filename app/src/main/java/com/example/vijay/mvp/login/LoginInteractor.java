package com.example.vijay.mvp.login;

public interface LoginInteractor {

    interface onLoginFinishedListener{

        void onUserNameError();
        void onPasswordError();
        void onSuccess();
        void onFailure(String message);

    }

    void login(String username,String password,onLoginFinishedListener listener);

}