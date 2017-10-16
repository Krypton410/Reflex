package com.example.edison.afinal;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;

import static android.transition.Fade.IN;

/**
 * Created by Edison on 01/10/2017.
 */

public class Home extends AppCompatActivity {

    ImageButton start,levels, exit;
    AlphaAnimation test;


    @Override
    protected void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.home);

        Explode explode = new Explode();
        explode.excludeTarget(R.layout.home, true);
        getWindow().setExitTransition(explode);

        test = new AlphaAnimation(9f, 0.9f);
        start = (ImageButton) findViewById(R.id.imageButton);
        levels = (ImageButton) findViewById(R.id.imageButton1);
        exit = (ImageButton) findViewById(R.id.imageButton2);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view.startAnimation(test);
                Intent i = new Intent(Home.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        levels.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                view.startAnimation(test);
                Intent i = new Intent(Home.this, Levels.class);
                startActivity(i);
                finish();

            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }

}
