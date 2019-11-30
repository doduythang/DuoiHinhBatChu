package com.example.duoihinhbatchu;

public interface LoginView {

    void login();

    void showLoading();

    void hideLoading();

    // hien thi loi khi user ko nhap Username
    void setErrorUsername();

    // hien thi loi khi user ko nhap password
    void setErrorPassword();

    // chuyen man hinh
    void navigate();


}
