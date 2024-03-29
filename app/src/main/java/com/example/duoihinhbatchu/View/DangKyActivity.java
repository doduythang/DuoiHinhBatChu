package com.example.duoihinhbatchu.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.duoihinhbatchu.DataBase.NguoiDungDao;
import com.example.duoihinhbatchu.Model.NguoiDung;
import com.example.duoihinhbatchu.R;


public class DangKyActivity extends AppCompatActivity {

    private EditText edUserName;
    private EditText edfullname;
    private EditText edtPassword;
    private EditText edtPassword2;
    private EditText edtphone;
    private Button btncanceluser;
    private Button btnadduser;

    NguoiDungDao nguoiDungDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        initView();
btncanceluser.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(DangKyActivity.this, LoginActivity.class);
        startActivity(intent);
    }
});
//        btnlistnguoidung.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DangKyActivity.this, HomeActivity.class);
//
//                Bundle b = new Bundle() ;
//
//                b.putString("USERNAME",edUserName.getText().toString());
//                b.putString("PHONE",edtphone.getText().toString() );
//                b.putString("FULLNAME",edfullname.getText().toString());
//                b.putString("PASSWORD",edtPassword.getText().toString());
//                intent.putExtras(b);
//
//                startActivity(intent);
//            }
//        });
        btnadduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });

    }

    private void initView() {

        edUserName = (EditText) findViewById(R.id.edUserName);
        edfullname = (EditText) findViewById(R.id.edfullname);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtPassword2 = (EditText) findViewById(R.id.edtPassword2);
//        edtphone = (EditText) findViewById(R.id.edtphone);
        btncanceluser = (Button) findViewById(R.id.btncanceluser);
        btnadduser = (Button) findViewById(R.id.btnadduser);

    }

    public void addUser() {
        nguoiDungDao = new NguoiDungDao(DangKyActivity.this);
        NguoiDung user = new NguoiDung(edUserName.getText().toString(), edtPassword.getText().toString()
               , edfullname.getText().toString());
        try {
            if (validateForm()>0){
                if (nguoiDungDao.insertNguoiDung(user)>0){
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    Intent b = new Intent(DangKyActivity.this, LoginActivity.class);
                    startActivity(b);

                }else {
                    Toast.makeText(getApplicationContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        }catch (Exception e){
            Log.e("Error",e.toString());

        }


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public int validateForm() {
        int check = 1;
        if (edUserName.getText().length() == 0 || edfullname.getText().length() == 0
                || edtPassword.getText().length() == 0
                || edtPassword2.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            String pass = edtPassword.getText().toString();
            String rePass= edtPassword2.getText().toString();
            if (pass.length()<6){
                edtPassword.setError(getString(R.string.notify_length_pass));
                check = -1;
            }
            if (!pass.equals(rePass)){
               edtPassword2.setError("Mật khẩu phải trùng nhau");
                check =-1;
            }

        }
        return check;
    }
}

