package com.example.duoihinhbatchu.View;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duoihinhbatchu.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class EndGameActivity extends AppCompatActivity {
//    private AdView mAdView;
    Button btnThoat,btnGameKhac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endgame);

        MobileAds.initialize(this, " ca-app-pub-3940256099942544~3347511713");
//        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        btnGameKhac=findViewById(R.id.btnGamekhac);
        btnThoat=findViewById(R.id.btnThoatGame);
        btnGameKhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EndGameActivity.this,"Đang liên kết game khác", Toast.LENGTH_LONG).show();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}