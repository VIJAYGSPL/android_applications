package com.example.vijay.mvp.login;

public interface LoginView {

    void showProgress();
    void hideProgress();
    void setUserNameError();
    void setPasswordError();
    void navigatetoMain();
    void showAlert(String message);

}
