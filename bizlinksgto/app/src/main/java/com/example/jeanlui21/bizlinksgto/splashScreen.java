package com.example.jeanlui21.bizlinksgto;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(splashScreen.this, MainActivity.class));
                finish(); }
                }, 2000); }
    }

