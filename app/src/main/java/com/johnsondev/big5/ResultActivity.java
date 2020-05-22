package com.johnsondev.big5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    private TextView block1;
    private TextView block2;
    private TextView block3;
    private TextView block4;
    private TextView block5;

    private int[] midScoreResult1;
    private int[] midScoreResult2;
    private int[] midScoreResult3;
    private int[] midScoreResult4;
    private int[] midScoreResult5;

    private int blockResult1;
    private int blockResult2;
    private int blockResult3;
    private int blockResult4;
    private int blockResult5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        block1 = findViewById(R.id.block_1);
        block2 = findViewById(R.id.block_2);
        block3 = findViewById(R.id.block_3);
        block4 = findViewById(R.id.block_4);
        block5 = findViewById(R.id.block_5);

        midScoreResult1 = new int[5];
        midScoreResult2 = new int[5];
        midScoreResult3 = new int[5];
        midScoreResult4 = new int[5];
        midScoreResult5 = new int[5];

        // block 1

        for (int i = 0; i < TestActivity.score.length; i++) {
            System.out.println("Score[" + i  + "] = " + TestActivity.score[i]);
        }

        for (int i = 0; i < 5; i++) {
            midScoreResult1[i] = TestActivity.score[i] + TestActivity.score[i + 5] + TestActivity.score[i + 10];
            System.out.print("mid[" + i + 1 + "] = " + midScoreResult1[i] + " ");
        }

        for (int i = 0; i < 5; i++) {
            blockResult1 += midScoreResult1[i];
        }

        block1.setText(String.valueOf(blockResult1));
        System.out.println("block = " + blockResult1);

        // block 2

        int index = 15;

        for (int i = 0; i < 5; i++) {
            midScoreResult2[i] = TestActivity.score[index] + TestActivity.score[index + 5] + TestActivity.score[index + 10];
            System.out.print("mid[" + i + 1 + "] = " + midScoreResult2[i] + " ");
            index++;
        }

        for (int i = 0; i < 5; i++) {
            blockResult2 += midScoreResult2[i];
        }

        block2.setText(String.valueOf(blockResult2));
        System.out.println("block = " + blockResult2);

        //block 3

        index = 30;

        for (int i = 0; i < 5; i++) {
            midScoreResult3[i] = TestActivity.score[index] + TestActivity.score[index + 5] + TestActivity.score[index + 10];
            System.out.print("mid[" + i + 1 + "] = " + midScoreResult3[i] + " ");
            index++;
        }

        for (int i = 0; i < 5; i++) {
            blockResult3 += midScoreResult3[i];
        }

        block3.setText(String.valueOf(blockResult3));
        System.out.println("block = " + blockResult3);

        //block 4

        index = 45;

        for (int i = 0; i < 5; i++) {
            midScoreResult4[i] = TestActivity.score[index] + TestActivity.score[index + 5] + TestActivity.score[index + 10];
            System.out.print("mid[" + i + 1 + "] = " + midScoreResult4[i] + " ");
            index++;
        }

        for (int i = 0; i < 5; i++) {
            blockResult4 += midScoreResult4[i];
        }

        block4.setText(String.valueOf(blockResult4));
        System.out.println("block = " + blockResult4);

        //block 5

        index = 60;

        for (int i = 0; i < 5; i++) {
            midScoreResult5[i] = TestActivity.score[index] + TestActivity.score[index + 5] + TestActivity.score[index + 10];
            System.out.print("mid[" + i + 1 + "] = " + midScoreResult5[i] + " ");
            index++;
        }

        for (int i = 0; i < 5; i++) {
            blockResult5 += midScoreResult5[i];
        }

        block5.setText(String.valueOf(blockResult5));
        System.out.println("block = " + blockResult5);


    }
}
