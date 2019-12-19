package com.example.duoihinhbatchu.Model;

public class NguoiDung {
    String userName;
    String password;
    String phone;
    String hoTen;
    double diem,level;

    public NguoiDung(String userName, String password, String phone, String hoTen, double diem, double level) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.hoTen = hoTen;
        this.diem = diem;
        this.level = level;
    }

    public NguoiDung(String userName, double diem, double level) {
        this.userName = userName;
        this.diem = diem;
        this.level = level;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public NguoiDung(String userName, String password, String hoTen) {
        this.userName = userName;
        this.password = password;
        this.hoTen = hoTen;
    }

    public NguoiDung(){}
    public NguoiDung(String userName, String password, String phone, String hoTen) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.hoTen = hoTen;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Override
    public String toString() {
        return "NguoiDung {"+
                "userName = '"+userName+'\''+
                ", password = ' "+password + '\''+
                ", phone = ' "+phone + '\''+
                ", hoTen = ' "+hoTen + '\''+
                '}';
    }
}
