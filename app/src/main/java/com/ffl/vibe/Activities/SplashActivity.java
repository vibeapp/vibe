package com.ffl.vibe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.ffl.vibe.R;

public class SplashActivity extends AppCompatActivity {
    private static int splash_time=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Launch Splash Screen
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },splash_time);
    }
}
