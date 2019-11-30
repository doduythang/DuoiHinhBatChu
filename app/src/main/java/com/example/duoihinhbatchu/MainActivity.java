package com.example.duoihinhbatchu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }




    public void OnGame(View view) {
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }

    public void OnChiaSe(View view) {
        Intent intent=new Intent(MainActivity.this,ChiaSeActivity.class);
        startActivity(intent);
    }

    public void OnHuongDan(View view) {
        Intent intent=new Intent(MainActivity.this,HuongDanActivity.class);
        startActivity(intent);
    }

    public void OnXepHang(View view) {
        Intent intent=new Intent(MainActivity.this,XepHangActivity.class);
        startActivity(intent);
    }

    public void DangXuat(View view) {
        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    public void DoiMatKhau(View view) {
        Intent intent=new Intent(MainActivity.this,DoiMatKhauActivity.class);
        startActivity(intent);
    }
}