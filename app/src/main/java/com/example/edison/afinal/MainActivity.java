package com.example.edison.afinal;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    List<ImageButton> triangles;
    TextView points, Instruction;
    int p = 0, limit = 100, soundId, subLimit = 10000;
    int sDuration = 10000,sSecond = 1000;
    int time = 10000, seconds = 1000;
    MediaPlayer sound, right, wrong, secondsSound, end;
    ProgressBar pbar;
    Fade fade;
    CountDownTimer timer;
    AlphaAnimation test;
    int[] color, changer;
    int i = 0;
    ImageButton l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, back;
    ImageButton[] r = new ImageButton[12];// l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    Slide slide;
    SoundPool sp;
    Drawable drawable;
    private static int time_out = 100;

/*    public void onClick(View view) {




          if(view.getSolidColor() == Color.BLACK){
            p =- 5;

          }
          else
              p =+ 5;
        points.setText(String.valueOf(p));

      }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setAllowEnterTransitionOverlap(true);
        slide = new Slide(Gravity.RIGHT);
        getWindow().setReturnTransition(slide);




        color = new int[5];
        color[0] = Color.parseColor("#E6D925");
        color[1] = Color.parseColor("#0007D6");
        color[2] = Color.parseColor("#1F2153");
        color[3] = Color.parseColor("#1F5339");
        color[4] = Color.parseColor("#C54515");


        changer = new int[9];
        changer[0] = Color.parseColor("#157FC5");
        changer[1] = Color.parseColor("#15A1C5");
        changer[2] = Color.parseColor("#15C5B9");
        changer[3] = Color.parseColor("#15C5A1");
        changer[4] = Color.parseColor("#15C573");
        changer[5] = Color.parseColor("#15C53E");
        changer[6] = Color.parseColor("#8BC515");
        changer[7] = Color.parseColor("#AFC515");
        changer[8] = Color.parseColor("#C5AE15");



        points = (TextView) findViewById(R.id.textView);

        test = new AlphaAnimation(9f, .110f);
        Instruction = (TextView) findViewById(R.id.textView3);
        pbar = (ProgressBar) findViewById(R.id.progressBar);

        l1 = (ImageButton) findViewById(R.id.one);
        l2 = (ImageButton) findViewById(R.id.two);
        l3 = (ImageButton) findViewById(R.id.three);
        l4 = (ImageButton) findViewById(R.id.four);
        l5 = (ImageButton) findViewById(R.id.five);
        l6 = (ImageButton) findViewById(R.id.six);
        l7 = (ImageButton) findViewById(R.id.seven);
        l8 = (ImageButton) findViewById(R.id.eight);
        l9 = (ImageButton) findViewById(R.id.nine);
        l10 = (ImageButton) findViewById(R.id.ten);

        l11 = (ImageButton) findViewById(R.id.eleven);
        l12 = (ImageButton) findViewById(R.id.twelve);
        back = (ImageButton) findViewById(R.id.imageButton12);

        l1.setTag(R.drawable.ic_black);
        l2.setTag(R.drawable.ic_black);
        l3.setTag(R.drawable.ic_black);
        l4.setTag(R.drawable.ic_black);
        l5.setTag(R.drawable.ic_black);
        l6.setTag(R.drawable.ic_black);
        l7.setTag(R.drawable.ic_black);
        l8.setTag(R.drawable.ic_black);
        l9.setTag(R.drawable.ic_black);
        l10.setTag(R.drawable.ic_black);
        l11.setTag(R.drawable.ic_black);
        l12.setTag(R.drawable.ic_black);

        sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

        soundId = sp.load(this.getApplicationContext(), R.raw.secondsfx, 1);



        r[0] = l1;
        r[1] = l2;
        r[2] = l3;

        r[3] = l4;
        r[4] = l5;
        r[5] = l6;
        r[6] = l7;
        r[7] = l8;
        r[8] = l9;
        r[9] = l10;
        r[10] = l11;
        r[11] = l12;


        points.setText(String.valueOf(p));
        int c = random(0, 11);

        r[5].setBackgroundResource(R.drawable.ic_red);
        r[5].setTag(R.drawable.ic_red);


        Toast.makeText(this, String.valueOf(c), Toast.LENGTH_SHORT).show();
        pbar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);


        end = MediaPlayer.create(MainActivity.this, R.raw.js);
        secondsSound = MediaPlayer.create(MainActivity.this, R.raw.secondsfx);
        sound = MediaPlayer.create(MainActivity.this, R.raw.not);
        right = MediaPlayer.create(MainActivity.this, R.raw.right);
        wrong = MediaPlayer.create(MainActivity.this, R.raw.wrong);
        countDown(time, 1000);

        r[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(test);

                //sound.start();

                if (l1.getTag().equals(R.drawable.ic_red)) {
                    right.start();
                    p += 5;
                    int c = random(0, 11);
                    r[0].setBackgroundResource(R.drawable.ic_black);
                    r[0].setTag(R.drawable.ic_black);
                    right.start();

                    r[c].setTag(R.drawable.ic_red);
                    r[c].setBackgroundResource(R.drawable.ic_red);

                } else if (l1.getTag().equals(R.drawable.ic_black)) {
                    p -= 5;
                    wrong.start();
                }

                points.setText(String.valueOf(p));
            }
        });

        r[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(test);
                if (l2.getTag().equals(R.drawable.ic_red)) {
                    right.start();
                    p += 5;
                    int c = random(0, 11);
                    r[1].setBackgroundResource(R.drawable.ic_black);
                    r[1].setTag(R.drawable.ic_black);
                    r[c].setTag(R.drawable.ic_red);
                    r[c].setBackgroundResource(R.drawable.ic_red);
                    right.start();
                } else if (l2.getTag().equals(R.drawable.ic_black)) {
                    p -= 5;
                    wrong.start();
                }

                points.setText(String.valueOf(p));
            }
        });

        r[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(test);
                if (l3.getTag().equals(R.drawable.ic_red)) {
                    right.start();
                    p += 5;
                    int c = random(0, 11);
                    r[2].setBackgroundResource(R.drawable.ic_black);
                    r[2].setTag(R.drawable.ic_black);
                    r[c].setTag(R.drawable.ic_red);
                    r[c].setBackgroundResource(R.drawable.ic_red);

                } else if (l3.getTag().equals(R.drawable.ic_black)) {
                    p -= 5;
                    int a = random(0, 11);
                    r[a].setTag(R.drawable.ic_red);
                    r[a].setBackgroundResource(R.drawable.ic_red);
                    wrong.start();
                }

                points.setText(String.valueOf(p));
            }
        });

        r[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(test);
                if (l4.getTag().equals(R.drawable.ic_red)) {
                    p += 5;
                    right.start();
                    int c = random(0, 11);
                    r[3].setBackgroundResource(R.drawable.ic_black);
                    r[3].setTag(R.drawable.ic_black);
                    r[c].setTag(R.drawable.ic_red);
                    r[c].setBackgroundResource(R.drawable.ic_red);
                } else if (l4.getTag().equals(R.drawable.ic_black)) {
                    p -= 5;
                    wrong.start();
                }

                points.setText(String.valueOf(p));
            }
        });

        r[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(test);
                if (l5.getTag().equals(R.drawable.ic_red)) {
                    right.start();
                    p += 5;
                    int c = random(0, 11);
                    r[4].setBackgroundResource(R.drawable.ic_black);
                    r[4].setTag(R.drawable.ic_black);
                    r[c].setTag(R.drawable.ic_red);
                    r[c].setBackgroundResource(R.drawable.ic_red);

                } else if (l5.getTag().equals(R.drawable.ic_black)) {
                    p -= 5;
                    wrong.start();
                }

                points.setText(String.valueOf(p));
            }
        });

        r[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(test);
                if (l6.getTag().equals(R.drawable.ic_red)) {
                    right.start();
                    p += 5;
                    int c = random(0, 11);
                    r[5].setBackgroundResource(R.drawable.ic_black);
                    r[5].setTag(R.drawable.ic_black);
                    r[c].setTag(R.drawable.ic_red);
                    r[c].setBackgroundResource(R.drawable.ic_red);

                } else if (l6.getTag().equals(R.drawable.ic_black)) {
                    p -= 5;
                    wrong.start();

                }

                points.setText(String.valueOf(p));
            }
        });

        r[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(test);
                if (l7.getTag().equals(R.drawable.ic_red)) {
                    p += 5;
                    right.start();
                    int c = random(0, 11);
                    r[6].setBackgroundResource(R.drawable.ic_black);
                    r[6].setTag(R.drawable.ic_black);
                    r[c].setTag(R.drawable.ic_red);
                    r[c].setBackgroundResource(R.drawable.ic_red);
                } else if (l7.getTag().equals(R.drawable.ic_black)) {
                    p -= 5;
                    wrong.start();
                }

                points.setText(String.valueOf(p));
            }
        });

        r[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(test);
                if (l8.getTag().equals(R.drawable.ic_red)) {
                    right.start();
                    p += 5;
                    int c = random(0, 11);
                    r[7].setBackgroundResource(R.drawable.ic_black);
                    r[7].setTag(R.drawable.ic_black);
                    r[c].setTag(R.drawable.ic_red);
                    r[c].setBackgroundResource(R.drawable.ic_red);

                } else if (l8.getTag().equals(R.drawable.ic_black)) {
                    p -= 5;
                    wrong.start();
                }

                points.setText(String.valueOf(p));
            }
        });

        r[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(test);
                if (l9.getTag().equals(R.drawable.ic_red)) {
                    p += 5;
                    right.start();
                    int c = random(0, 11);
                    r[8].setBackgroundResource(R.drawable.ic_black);
                    r[8].setTag(R.drawable.ic_black);
                    r[c].setTag(R.drawable.ic_red);
                    r[c].setBackgroundResource(R.drawable.ic_red);
                } else if (l9.getTag().equals(R.drawable.ic_black)) {
                    p -= 5;
                    wrong.start();
                }

                points.setText(String.valueOf(p));
            }
        });

        r[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(test);
                if (l10.getTag().equals(R.drawable.ic_red)) {
                    right.start();
                    p += 5;

                    int c = random(0, 11);
                    r[9].setBackgroundResource(R.drawable.ic_black);
                    r[9].setTag(R.drawable.ic_black);
                    r[c].setTag(R.drawable.ic_red);
                    r[c].setBackgroundResource(R.drawable.ic_red);
                } else if (l10.getTag().equals(R.drawable.ic_black)) {
                    p -= 5;
                    wrong.start();
                }

                points.setText(String.valueOf(p));
            }
        });


        r[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(test);
                if (l11.getTag().equals(R.drawable.ic_red)) {
                    right.start();
                    p += 5;
                    int c = random(0, 11);
                    r[10].setBackgroundResource(R.drawable.ic_black);
                    r[10].setTag(R.drawable.ic_black);
                    r[c].setTag(R.drawable.ic_red);
                    r[c].setBackgroundResource(R.drawable.ic_red);

                } else if (l11.getTag().equals(R.drawable.ic_black)) {
                    p -= 5;
                    wrong.start();
                }

                points.setText(String.valueOf(p));
            }
        });

        r[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(test);
                if (l12.getTag().equals(R.drawable.ic_red)) {
                    right.start();
                    p += 5;
                    r[11].setBackgroundResource(R.drawable.ic_black);
                    r[11].setTag(R.drawable.ic_black);
                    int a = random(0, 11);
                    r[a].setTag(R.drawable.ic_red);
                    r[a].setBackgroundResource(R.drawable.ic_red);

                } else if (l12.getTag().equals(R.drawable.ic_black)) {
                    p -= 5;
                    wrong.start();

                }

                points.setText(String.valueOf(p));
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondsSound.stop();
                sp.release();

                Intent i = new Intent(MainActivity.this, Home.class);
                getWindow().setReturnTransition(slide);
                startActivity(i);
                finish();
            }
        });

    }

    public int random(int min, int max) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(max + 1 - min) + min;
        return randomNumber;

    }
    public void countDown(final int duration, final int seconds){
        pbar.setProgress(0);
        new CountDownTimer(duration, seconds){
            int i = 0;
            float j = 0f;
            int calib = (i*100/(duration/seconds));
            @Override
            public void onTick(long l) {
                i++;

                pbar.setProgress(i*100/(duration/seconds));
                j += 0.030f;
                //secondsSound.start();
                calib += 1;
                sp.play(soundId, 1, 1, 0, 1, 1); //former j
                pbar.getProgressDrawable().setColorFilter(changer[random(0,8)], PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onFinish() {
                i++;
                calib = 0;
                pbar.setProgress(100);

                if(Integer.valueOf(points.getText().toString()) < limit){
                    Intent i = new Intent(MainActivity.this, Scare.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in_fast, R.anim.fade_out_fast);
                    finish();
                    Toast.makeText(MainActivity.this, "YOU FAILED", Toast.LENGTH_SHORT).show();
                    secondsSound.stop();
                    end.seekTo(7);
                    end.start();
                    sp.release();

                }
                else {

                    pbar.setProgress(0);
                    limit += 100;
                    time = 0;
                    time += subLimit;
                    subLimit -= 1000;

                    Instruction.setText("Points to Reach: " + limit + " points");
                    countDown(time,1000);
                    Toast.makeText(MainActivity.this, ""+time, Toast.LENGTH_SHORT).show();
                    sp.setLoop(soundId,0);
                    pbar.getProgressDrawable().setColorFilter(color[random(0,4)], PorterDuff.Mode.SRC_IN);

                }

            }
        }.start();
    }


/*    public  void speedSound(int theDuration, int sSeconds){

        new CountDownTimer(theDuration, sSeconds){

            @Override
            public void onTick(long l) {

                secondsSound.start();

            }

            @Override
            public void onFinish() {

                if(Integer.valueOf(points.getText().toString()) < limit){

                    Toast.makeText(MainActivity.this, "FUCKCK", Toast.LENGTH_SHORT).show();
                    secondsSound.stop();

                }


            }
        }.start();

    }*/



}


