package com.quizzood2.etiennemaxime.quizzood2;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.quizzood2.etiennemaxime.quizzood2.Common.Common;

public class Playing extends AppCompatActivity implements View.OnClickListener{

    final static long INTERVAL = 2000;
    final static long TIMEOUT = 12000;
    int progressValue = 0;

    CountDownTimer mCountDown;

    int index=0, score=0, thisQuestion=0, totalQuestion, correctAnswer;

    ProgressBar progressBar;
    Button btn1, btn2, btn3, btn4;
    TextView txtScore, txtQuestionNum, question_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        txtScore = (TextView) findViewById(R.id.txtScore);
        txtQuestionNum = (TextView) findViewById(R.id.txtTotalQuestion);
        question_text = (TextView) findViewById(R.id.question_text);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btn1 = (Button) findViewById(R.id.btnAnswer1);
        btn2 = (Button) findViewById(R.id.btnAnswer2);
        btn3 = (Button) findViewById(R.id.btnAnswer3);
        btn4 = (Button) findViewById(R.id.btnAnswer4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        mCountDown.cancel();
        if (index < totalQuestion) // still have Question
        {
            Button clickedButton = (Button) view;
            if (clickedButton.getText().equals(Common.questionList.get(index).getCorrectAnswer()))
            {
                score+=10;
                correctAnswer ++;
                showQuestion(++index);
            }
            else {
                showQuestion(++index);
            }
            txtScore.setText(String.format("%d", score));
        }
    }

    private void showQuestion (int index){
        if (index < totalQuestion){
            thisQuestion++;
            txtQuestionNum.setText(String.format("%d / %d", thisQuestion, totalQuestion));
            question_text.setText(Common.questionList.get(index).getQuestion());
            progressBar.setProgress(0);
            progressValue = 0;

            btn1.setText(Common.questionList.get(index).getAnswer1());
            btn2.setText(Common.questionList.get(index).getAnswer2());
            btn3.setText(Common.questionList.get(index).getAnswer3());
            btn4.setText(Common.questionList.get(index).getAnswer4());

            mCountDown.start(); // start timer
        }
        else {
            // Questions Finished
            Intent intent = new Intent(this, Done.class);
            Bundle dataSend = new Bundle();
            dataSend.putInt("SCORE", score);
            dataSend.putInt("TOTAL", totalQuestion);
            dataSend.putInt("CORRECT", correctAnswer);
            intent.putExtras(dataSend);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        totalQuestion = Common.questionList.size();
        mCountDown = new CountDownTimer(TIMEOUT, INTERVAL) {
            @Override
            public void onTick(long minisec) {
                progressBar.setProgress(progressValue);
                progressValue ++;
            }

            @Override
            public void onFinish() {
                mCountDown.cancel();
                showQuestion(++index);
            }
        };
        showQuestion(index);
    }
}
