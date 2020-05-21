package com.johnsondev.big5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private TextView block1;


    private int[] midScoreResult;
    private int blockResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        block1 = findViewById(R.id.block_1);


        midScoreResult = new int[5];

        for (int i = 0; i < TestActivity.score.length; i++) {
            System.out.println("Score[" + i  + "] = " + TestActivity.score[i]);
        }

        for (int i = 0; i < midScoreResult.length; i++) {
            midScoreResult[i] = TestActivity.score[i] + TestActivity.score[i + 5] + TestActivity.score[i + 10];
            System.out.print("mid[" + i + 1 + "] = " + midScoreResult[i] + " ");
        }


        for (int i = 0; i < midScoreResult.length; i++) {
            blockResult += midScoreResult[i];
        }

        block1.setText(String.valueOf(blockResult));
        System.out.println("block = " + blockResult);


    }
}
