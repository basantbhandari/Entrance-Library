package com.example.yesicbap.entrancelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yesicbap.entrancelibrary.AccountActivity.LoginActivity;

public class SpashScreenActivity extends AppCompatActivity {

    private TextView tv;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);

        tv = findViewById(R.id.splash_screen_activity_welcome_message);
        iv = findViewById(R.id.splesh_screen_activity_iv_logo);
        Animation myAnimation = AnimationUtils.loadAnimation(SpashScreenActivity.this,R.anim.animtransition);
        tv.startAnimation(myAnimation);
        iv.startAnimation(myAnimation);
        Thread timer = new Thread(){

            public void run(){
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {

                    Intent intent = new Intent(SpashScreenActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }


        };
        timer.start();

    }
}
