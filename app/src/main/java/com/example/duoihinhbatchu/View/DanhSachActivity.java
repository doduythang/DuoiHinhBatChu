package com.example.duoihinhbatchu.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.duoihinhbatchu.Adapter.NguoiDungAdapter;

import com.example.duoihinhbatchu.DataBase.DatabaseHelper;
import com.example.duoihinhbatchu.DataBase.NguoiDungDao;

import com.example.duoihinhbatchu.Model.NguoiDung;

import com.example.duoihinhbatchu.R;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class DanhSachActivity extends AppCompatActivity {


        public static List<NguoiDung> dsNguoiDung = new ArrayList<>();
        ListView lvnguoidung;
        NguoiDungAdapter adapter=null;
        NguoiDungDao nguoiDungDao;


        private FloatingActionButton fab;
    String  username;
        @Override
        protected void onResume() {
            super.onResume();
            dsNguoiDung.clear();
            dsNguoiDung = nguoiDungDao.getAllNguoiDung();
            adapter.changeDataset(nguoiDungDao.getAllNguoiDung());


        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_danhsach);
            setTitle("Xếp hạng");
            Intent intent = getIntent();
            Bundle b5 = intent.getExtras();
           username = b5.getString("USERNAME");

            ActionBar actionBar = getSupportActionBar();


            lvnguoidung = findViewById(R.id.customlvnguoidung);
            nguoiDungDao = new NguoiDungDao(DanhSachActivity.this);
            dsNguoiDung = nguoiDungDao.getAllNguoiDung();

            adapter = new NguoiDungAdapter(dsNguoiDung, this);

            lvnguoidung.setAdapter(adapter);



        }

    public void OnHome(View view) {
            Intent i= new Intent(DanhSachActivity.this,HomeActivity.class);
        Bundle b = new Bundle();
        b.putString("USERNAME", username);
       i.putExtras(b);
            startActivity(i);
    }
}