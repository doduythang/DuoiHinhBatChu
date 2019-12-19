package com.example.duoihinhbatchu.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duoihinhbatchu.Model.NguoiDung;
import com.example.duoihinhbatchu.DataBase.NguoiDungDao;

import com.example.duoihinhbatchu.R;

import com.facebook.CallbackManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class HomeActivity extends AppCompatActivity {
    TextView edFullName, edusername;
    private AlertDialog alertDialog;
    Button btplay;
    public static boolean at;
    TextView Ten, Diem;
    private MediaPlayer mediaPlayer;
    Button btnAmThanh;
    String username, fullname, phone;
    NguoiDung nguoiDung;
    NguoiDungDao nguoiDungDao;
    String KEY = "a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
                Intent intent = new Intent(HomeActivity.this, PlayActivity.class);
                Bundle b = new Bundle();
                b.putString("USERNAME", username);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        at=getIntent().getBooleanExtra("at",true);
        if (at==false){
            btnAmThanh.setText("Âm thanh: Tắt");
        }

        backMusic();

    }


    private void initView() {
        edFullName = findViewById(R.id.tvName);
        edusername = findViewById(R.id.tvDiem);
        btnAmThanh = findViewById(R.id.btnAmThanh);


    }
    public void turnOnSound(View view) {
        String text = btnAmThanh.getText().toString();
        if (text.equals("Âm thanh: Bật")) {
            btnAmThanh.setText("Âm thanh: Tắt");
            HomeActivity.at = false;
            stopBackMusic();
            at = false;
        } else {
            at = true;
            HomeActivity.at = true;
            btnAmThanh.setText("Âm thanh: Bật");
            backMusic();
        }
    }

    public void backMusic() {
        if (at==true) {
            mediaPlayer = MediaPlayer.create(this, R.raw.nhac_game);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                    mediaPlayer.start();
                }
            });
        }

    }

    public void stopBackMusic() {
        if (at==false) {

            mediaPlayer.release();
        }
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view1 = LayoutInflater.from(this).inflate(R.layout.dialog_huongdan, null);
        builder.setView(view1);

        ImageView imgClose;
        imgClose = view1.findViewById(R.id.imgv_close_dialog_huongdan);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();

            }
        });
        builder.create();
        alertDialog = builder.show();
        builder.setCancelable(false);
    }

    public void OnXepHang(View view) {
        Intent intent = new Intent(HomeActivity.this, DanhSachActivity.class);
        Bundle b = new Bundle();
        b.putString("USERNAME", username);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void dangXuat(View view) {
        Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}