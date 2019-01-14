package com.example.yesicbap.entrancelibrary;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.yesicbap.entrancelibrary.AccountActivity.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ResultActivity extends AppCompatActivity {

    TextView t1,t2,t3,t11,t22,t33;
    private Button playAgain,signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t1 = findViewById(R.id.result_tv_total_question);
        t2 = findViewById(R.id.result_tv_correct_answer);
        t3 = findViewById(R.id.result_tv_incorrect_answer);
        t11 = findViewById(R.id.result_tv_total_question_option);
        t22 = findViewById(R.id.result_tv_correct_answer_option);
        t33 = findViewById(R.id.result_tv_incorrect_answer_option);

        playAgain = findViewById(R.id.result_activity_btn_play_again);
        signOut = findViewById(R.id.result_activity_btn_log_out);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playagainIntent = new Intent(ResultActivity.this,GoingActivity.class);
                startActivity(playagainIntent);
                finish();
            }
        });


        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to sign out the user user
                FirebaseAuth.getInstance().signOut();
                Intent signOutIntent = new Intent(ResultActivity.this,LoginActivity.class);
                startActivity(signOutIntent);
                finish();
            }
        });

        Intent i = getIntent();
        String questions = i.getStringExtra("total");
        String corrects = i.getStringExtra("correct");
        String incorrects = i.getStringExtra("incorrect");

        t11.setText(questions);
        t22.setText(corrects);
        t33.setText(incorrects);

    }
}
