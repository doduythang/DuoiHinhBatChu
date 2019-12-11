package com.example.duoihinhbatchu.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.duoihinhbatchu.Presenter.LoginPresenter;
import com.example.duoihinhbatchu.Model.NguoiDung;
import com.example.duoihinhbatchu.DataBase.NguoiDungDao;
import com.example.duoihinhbatchu.R;


public class LoginActivity extends AppCompatActivity implements LoginView {
    private LoginPresenter loginPresenter;
    private EditText edtUsername;
    private EditText edtPassword;
    NguoiDungDao nguoiDungDao;
    private Button btnLogin;

    private CheckBox cbRemember;



    //adads



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            edtUsername = (EditText) findViewById(R.id.edtUsername);
            edtPassword = (EditText) findViewById(R.id.edtPassword);
//        cbRemember = (CheckBox) findViewById(R.id.cbRemember);
            btnLogin = (Button) findViewById(R.id.btnLogin);
            nguoiDungDao = new NguoiDungDao(getApplicationContext());

            NguoiDung user2;
            user2 = nguoiDungDao.getUser("admin");
            if (user2 == null) {
                NguoiDung user3 = new NguoiDung("admin", "1234567", "0355827535", "Phạm Đức Thắng");
                nguoiDungDao.insertNguoiDung(user3);
            }
            checkLogin();

            edtUsername.setText("admin");
            edtPassword.setText("1234567");


        }


        public void checkLogin() {
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    String userName = edtUsername.getText().toString().trim();
                    String password = edtPassword.getText().toString().trim();
                    if (password.length() < 6 || userName.isEmpty() || password.isEmpty()) {

                        if (userName.isEmpty())
                            edtUsername.setError(getString(R.string.notify_empty_user));

                        if (password.isEmpty())
                            edtPassword.setError(getString(R.string.notify_empty_pass));


                    } else {


                        NguoiDung user = nguoiDungDao.getUser(userName);
                        if (user != null && user.getUserName() != null) {
                            if (password.matches(user.getPassword())) {
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                Bundle b = new Bundle() ;
                                b.putString("USERNAME",user.getUserName());
                                b.putString("key","a");
                                intent.putExtras(b);
                                startActivity(intent);
                                finish();
                                Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            } else {

                                Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu chưa chính xác", Toast.LENGTH_SHORT).show();

                            }
                        } else {
                            Toast.makeText(LoginActivity.this, "Bạn chưa có tài khoản", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

        }



        public void rememberUser(String u, String p, boolean status) {
            SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
            SharedPreferences.Editor edit = pref.edit();
            if (!status) {
                edit.clear();
            } else {
                edit.putString("USERNAME", u);
                edit.putString("PASSWORD", p);
                edit.putBoolean("REMEMBER", status);
            }
            edit.commit();
        }





        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId())
            {
                case android.R.id.home:
                    onBackPressed();
                    return true;

                default:break;
            }

            return super.onOptionsItemSelected(item);
        }

        public void OpenMenu(View view) {
            Intent intent=new Intent(this, HomeActivity.class);
            startActivity(intent);

        }


//    public void login(View view) {
////        String username = edtUsername.getText().toString().trim();
////        String password = edtPassword.getText().toString().trim();
////        loginPresenter.login(username,password);
//        checkLogin();
//    }


    @Override
    public void login() {


    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void setErrorUsername() {
        Toast.makeText(this,"Vui long nhap Username",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setErrorPassword() {
        Toast.makeText(this,"Vui long nhap Password",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigate() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }


    public void Dangky(View view) {
            Intent intent= new Intent(LoginActivity.this, DangKyActivity.class);
            startActivity(intent);

    }
}


