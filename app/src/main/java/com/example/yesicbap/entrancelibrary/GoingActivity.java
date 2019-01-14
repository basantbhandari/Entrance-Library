package com.example.yesicbap.entrancelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yesicbap.entrancelibrary.AccountActivity.LoginActivity;

public class GoingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_going);

        Thread timer = new Thread(){

            public void run(){
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {

                    Intent intent = new Intent(GoingActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }


        };
        timer.start();

    }
}
