package com.example.yesicbap.entrancelibrary;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yesicbap.entrancelibrary.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


     Button b1,b2,b3,b4;
     TextView tv_question,timePeriod;

     int total = 1;
     int correct = 0;
     int wrong = 0;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.main_btn_option1);
        b2 = findViewById(R.id.main_btn_option2);
        b3 = findViewById(R.id.main_btn_option3);
        b4 = findViewById(R.id.main_btn_option4);
        tv_question = findViewById(R.id.main_tv_question);
        timePeriod = findViewById(R.id.main_tv_time_duration);

        updateQuestion();
        reversTimer(7200,timePeriod);

    }

    private void updateQuestion() {
        total++;
        if (total > 5){
            total-=2;
            Intent iIntent = new Intent(MainActivity.this,ResultActivity.class);
            iIntent.putExtra("total",String.valueOf(total));
            iIntent.putExtra("correct",String.valueOf(correct));
            iIntent.putExtra("incorrect",String.valueOf(wrong));
            startActivity(iIntent);

            //to show result activity
        }else {
            databaseReference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Question question = dataSnapshot.getValue(Question.class);

                    //setting data to view field from firebase
                    tv_question.setText(question.getQuestion());
                    b1.setText(question.getOption1());
                    b2.setText(question.getOption2());
                    b3.setText(question.getOption3());
                    b4.setText(question.getOption4());



                    //on click option 1
                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //if option 1 is true
                            if (b1.getText().toString().equals(question.getAnswer())){
                                b1.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        updateQuestion();
                                    }
                                },1500);
                            }else {
                                //find correct answer and make it green and update question
                                wrong++;
                                b1.setBackgroundColor(Color.RED);
                                if (b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                }else if (b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                }else if (b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                }



                                //to return in initial color background after 1.5 sec
                                Handler mHandler = new Handler();
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        b2.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        b3.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        b4.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        updateQuestion();
                                    }
                                }, 1500);


                            }

                        }
                    });



                    //on click button 2
                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //if option 2 is true
                            if (b2.getText().toString().equals(question.getAnswer())){
                                b2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b2.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        updateQuestion();
                                    }
                                },1500);
                            }else {
                                //find correct answer and make it green and update question
                                wrong++;
                                b2.setBackgroundColor(Color.RED);
                                if (b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                }else if (b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                }else if (b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                }



                                //to return in initial color background after 15 sec
                                Handler mHandler = new Handler();
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        b2.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        b3.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        b4.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        updateQuestion();
                                    }
                                }, 1500);


                            }
                        }
                    });


                    //on click option 3
                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //if option 3 is true
                            if (b3.getText().toString().equals(question.getAnswer())){
                                b3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b3.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        updateQuestion();
                                    }
                                },1500);
                            }else {
                                //find correct answer and make it green and update question
                                wrong++;
                                b3.setBackgroundColor(Color.RED);
                                if (b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                }else if (b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                }else if (b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                }



                                //to return in initial color background after 15 sec
                                Handler mHandler = new Handler();
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        b2.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        b3.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        b4.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        updateQuestion();
                                    }
                                }, 1500);


                            }
                        }
                    });


                    //on click option 4
                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //if option 4 is true
                            if (b4.getText().toString().equals(question.getAnswer())){
                                b4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b4.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        updateQuestion();
                                    }
                                },1500);
                            }else {
                                //find correct answer and make it green and update question
                                wrong++;
                                b4.setBackgroundColor(Color.RED);
                                if (b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                }else if (b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                }else if (b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                }



                                //to return in initial color background after 15 sec
                                Handler mHandler = new Handler();
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        b2.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        b3.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        b4.setBackgroundColor(Color.parseColor("#FFD81BB9"));
                                        updateQuestion();
                                    }
                                }, 1500);


                            }
                        }
                    });








                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            
        }
    }


    //timer method
    public void reversTimer(int second,final TextView tv){

        new CountDownTimer(second*1000 + 1000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int)(millisUntilFinished/1000);
                int hours = seconds/3600;
                seconds = seconds % 3600;
                int minutes = seconds/60;
                seconds = seconds % 60;
                tv.setText( String.format("%02d",hours) + ":" +  String.format("%02d",minutes) + ":" + String.format("%02d",seconds) );
            }
            @Override
            public void onFinish() {
                tv.setText("completed");
                Intent myIntent = new Intent(MainActivity.this,ResultActivity.class);
                myIntent.putExtra("total",String.valueOf(total));
                myIntent.putExtra("correct",String.valueOf(correct));
                myIntent.putExtra("incorrect",String.valueOf(wrong));
                startActivity(myIntent);
            }
        }.start();


    }


}
