package com.example.edison.afinal;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.util.Random;

/**
 * Created by Edison on 17/10/2017.
 */

public class Scare extends AppCompatActivity {
    VideoView one;
    int[] vids;
    Button b;
    DisplayMetrics metrics;
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.scare);
        b = (Button) findViewById(R.id.button);
        vids = new int[2];
        vids[0] = R.raw.scareportrait;
        vids[1] = R.raw.scare2portrait;





        one = (VideoView) findViewById(R.id.videoView);
        one.setVideoURI(Uri.parse("android.resource://" + getPackageName()+"/" + vids[random(0,1)]));





        one.start();
        one.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Scare.this, Home.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in_fast, R.anim.fade_out_fast);
                finish();
            }
        });
    }
    public int random(int min, int max) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(max + 1 - min) + min;
        return randomNumber;

    }
}
