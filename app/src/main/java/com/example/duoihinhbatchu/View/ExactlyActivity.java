package com.example.duoihinhbatchu.View;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duoihinhbatchu.DataBase.NguoiDungDao;

import com.example.duoihinhbatchu.Model.NguoiDung;

import com.example.duoihinhbatchu.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class ExactlyActivity extends AppCompatActivity {
    NguoiDungDao nguoiDungDao;
    NguoiDung nguoiDung;
    String username;
    TextView tvchuc,tvDiem;
    Button btnTiep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exactly);
        nguoiDungDao = new NguoiDungDao(getApplicationContext());
        nguoiDung = new NguoiDung();
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        username = b.getString("USERNAME");
        tvDiem=findViewById(R.id.tvDiem1);
        tvchuc=findViewById(R.id.chuc);
        btnTiep=findViewById(R.id.btnTiep);
        addControl();
    }
    private void addControl() {
        Intent i=getIntent();
        String s=i.getStringExtra("a");
        final String r=i.getStringExtra("r");
        final String l=i.getStringExtra("l");
        final Double diem=Double.parseDouble(r)-5;
        int t= Integer.parseInt(s);

        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(ExactlyActivity.this, PlayActivity.class);
                Bundle b = new Bundle();
                b.putString("USERNAME", username);
                if (nguoiDungDao.updateInfoNguoiDung(username,String.valueOf(diem),nguoiDungDao.getUser(username).getHoTen())>0){
                    Toast.makeText(getApplicationContext(), "Lưu Thành Công", Toast.LENGTH_SHORT).show();
                }
                in.putExtras(b);
                startActivity(in); finish();
            }
        });
    }





}
