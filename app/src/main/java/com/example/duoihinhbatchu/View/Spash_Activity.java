package com.example.duoihinhbatchu.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.duoihinhbatchu.R;

public class Spash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Spash_Activity.this,LoginActivity.class);
                Spash_Activity.this.startActivity(mainIntent);
                Spash_Activity.this.finish();
            }
        }, 2000);
    }

}
