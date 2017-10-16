package com.example.edison.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Edison on 01/10/2017.
 */

public class SplashScreen extends AppCompatActivity {
    private static int time_out = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();

        this.setTitle("");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, Home.class);
                startActivity(i);
                finish();
            }
        },time_out);
    }
}
