package com.example.duoihinhbatchu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView edFullName, edusername;

    Button btnchangePass;
    Button btplay;

    TextView Ten, Diem;

    String username, fullname, phone;
    NguoiDung nguoiDung;
    NguoiDungDao nguoiDungDao;
    String KEY = "a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        nguoiDungDao = new NguoiDungDao(getApplicationContext());
        nguoiDung = new NguoiDung();
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        username = b.getString("USERNAME");
        nguoiDung = nguoiDungDao.getUser(username);
        edFullName.setText(nguoiDung.hoTen);
        edusername.setText(nguoiDung.userName);


        btplay = findViewById(R.id.btnPlay);
        btplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle b = new Bundle();
                b.putString("USERNAME", username);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }


    private void initView() {
        edFullName = findViewById(R.id.tvName);
        edusername = findViewById(R.id.tvDiem);


    }


    public void OnChiaSe(View view) {
        Intent intent = new Intent(MainActivity.this, ChiaSeActivity.class);
        startActivity(intent);
    }

    public void OnHuongDan(View view) {
        Intent intent = new Intent(MainActivity.this, HuongDanActivity.class);
        startActivity(intent);
    }

    public void OnXepHang(View view) {
        Intent intent = new Intent(MainActivity.this, XepHangActivity.class);
        startActivity(intent);
    }

    public void DangXuat(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void DoiMatKhau(View view) {
        Intent intent = new Intent(MainActivity.this, DoiMatKhauActivity.class);
        startActivity(intent);
    }
}