package com.example.vijay.mvp.login;

public interface LoginPresenter {

    void validateCred(String username,String password);
    void onDestroy();
}
