package com.example.duoihinhbatchu.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.duoihinhbatchu.Model.NguoiDung;
import com.example.duoihinhbatchu.DataBase.NguoiDungDao;
import com.example.duoihinhbatchu.R;

import com.facebook.CallbackManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

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
        edFullName.setText(nguoiDung.getHoTen());
        edusername.setText(nguoiDung.getUserName());


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
        ShareDialog shareDialog = new ShareDialog(this);

        CallbackManager callbackManager = CallbackManager.Factory.create();

        ShareLinkContent shareLinkContent = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://play.google.com/store/apps/details?id=com.bhmedia.duoihinh&hl=vi"))
                .build();
        shareDialog.show(shareLinkContent);
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