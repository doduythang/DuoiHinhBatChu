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


    private final String[] Key={
            "HỘI ĐỒNG","ÁO MƯA","Ô TÔ","ĐÀN ÔNG","XÀ KÉP","TÔ HOÀI","CAN THIỆP","CÁT TƯỜNG",
            "DÁNH LỪA","TÍCH PHÂN","QUY HÀNG","SONG HÀNH","THỎ THẺ","THẤT TÌNH","TRANH THỦ",
            "TỔ TIÊN","MA SÁT","HỒNNG TÂM","BÀI BẠC","BÍ BÁCH","CHIA SẺ","CHÍN CHẮN","CỦ SU HÀO","DÊ TIỆN","ĐỔI TRẮNG THAY ĐEN",
            "FIFA","GIAO DIỆN","HOÀNG HẬU","HOÀNH TRÁNG","HỌC LỆCH","HỒI HỘP","HỒ VIỆT TRUNG",
            "KHAI THÁC","LA BÀN","LÃNH ĐẠO","MIÊU TẢ","NHẬT BẢN","ÔNG BẦU","QUY CHUẨN",
            "TÁM LẠNG NỬA CÂN","TÊ THẤP","THÔNG THOÁNG","THƯƠNG HIÊU","TỐI CAO","TRƯỜNG SƠN TÂY","TUNG TĂNG"
    };
    TextView tvdapan,tvchuc,tvDiem;
    Button btnTiep,btnThoat;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exactly);
        nguoiDungDao = new NguoiDungDao(getApplicationContext());
        nguoiDung = new NguoiDung();
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        username = b.getString("USERNAME");
        addEvent();
        addControl();


    }

    private void addControl() {
        loadData();
        Intent i=getIntent();
        String s=i.getStringExtra("a");
        final String r=i.getStringExtra("r");
        final String l=i.getStringExtra("l");



        final Double diem=Double.parseDouble(r)-5;
        final Double level=Double.parseDouble(l)-1;

        //System.out.println(" s là : "+s);
        int t= Integer.parseInt(s);
        tvchuc.setText("Chuc Mung :"+username);
        tvDiem.setText(diem+"  +5");
        tvdapan.setText(Key[t]+"   level: "+ level);
        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(ExactlyActivity.this, PlayActivity.class);
                Bundle b = new Bundle();


                b.putString("USERNAME", username);

                if (nguoiDungDao.updateInfoNguoiDung(username,String.valueOf(diem),nguoiDungDao.getUser(username).getHoTen())>0){
                    Toast.makeText(getApplicationContext(), "Lưu Thành Công", Toast.LENGTH_SHORT).show();

//            Intent a = new Intent(ChiTietNguoiDungActivity.this,NguoidungActivity.class);
//            startActivity(a);
                }

                in.putExtras(b);
                startActivity(in); finish();
            }
        });
    }

    private void loadData() {


    }

    private void addEvent() {
        tvDiem=findViewById(R.id.tvDiem1);
        tvdapan=findViewById(R.id.tvdapan);
        tvchuc=findViewById(R.id.chuc);
        btnTiep=findViewById(R.id.btnTiep);
    }




}
