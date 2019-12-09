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

public class MainActivity extends AppCompatActivity {
    TextView edFullName, edusername;

    Button btnchangePass;
    Button btplay;

TextView Ten,Diem;
    NguoiDungDao nguoiDungDao;
    String username,fullname,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
initView();

        Intent intent = getIntent();
        Bundle b= intent.getExtras();
        username = b.getString("USERNAME");
        fullname=b.getString("FULLNAME");
        edFullName.setText(fullname);
        edusername.setText(username);
        btplay=findViewById(R.id.btnPlay);
        btplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                Bundle b = new Bundle() ;
                b.putString("USERNAME",username);
                b.putString("FULLNAME",fullname);

                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }


    private void initView() {
        edFullName =  findViewById(R.id.tvName);
        edusername =  findViewById(R.id.tvDiem);


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