package com.example.edison.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;

/**
 * Created by Edison on 01/10/2017.
 */

public class Levels extends AppCompatActivity {
    ImageButton back, one, two, three;
    AlphaAnimation effect;
    @Override
    protected void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.levels);
        back = (ImageButton) findViewById(R.id.back);
        one = (ImageButton) findViewById(R.id.imageButton3) ;






        effect = new AlphaAnimation(9f, 0.5f);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Levels.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(effect);
                Intent i = new Intent(Levels.this, Home.class);
                startActivity(i);
                finish();
            }
        });

    }




}

