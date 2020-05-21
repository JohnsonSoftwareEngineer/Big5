package com.johnsondev.big5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    private TextView greenText, redText;
    private TextView numberOfTest;
    private RadioButton radio_Min2, radio_Min1, radio_0, radio_1, radio_2;
    private Button nextBtn;
    private ProgressBar progressBar;
    private RadioGroup radioGroup;

    private RelativeLayout root;


    private int index = 1;
    int i = 0;

    private String[] question_green;
    private String[] question_red;
    static int[] score;




    // TODO: 21.05.2020 конвертировать score в массив[15] и изменить это в EvaluationScore, и ResultActivity 



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //   questions

        question_green = new String[15];
        question_red = new String[15];
        score = new int[15];

        //green

        question_green[0] = "Мне нравится заниматься физкультурой";
        question_green[1] = "Люди считают меня отзывчивым и доброжелательным человеком";
        question_green[2] = "Я во всем ценю чистоту и порядок";
        question_green[3] = "Меня часто беспокоит мысль, что что-нибудь может случиться";
        question_green[4] = "Все новое вызывает у меня интерес";
        question_green[5] = "Если я ничем не занят, то это меня беспокоит";
        question_green[6] = "Я стараюсь проявлять дружелюбие ко всем людям";
        question_green[7] = "Моя комната всегда аккуратно прибрана";
        question_green[8] = "Иногда я расстраиваюсь из-за пустяков";
        question_green[9] = "Мне нравятся неожиданности";
        question_green[10] = "Я не могу долго оставаться в неподвижности";
        question_green[11] = "Я тактичен по отношения к другим людям";
        question_green[12] = "Я методичен и пунктуален во всем ";
        question_green[13] = "Мои чувства легко уязвимы и ранимы";
        question_green[14] = "Мне не интересно, когда ответ ясен заранее";

        //red

        question_red[0] = "Я не люблю физические нагрузки";
        question_red[1] = "Некоторые люди считают меня холодным и черствым";
        question_red[2] = "Иногда я позволяю себе быть неряшливым";
        question_red[3] = "«Мелочи жизни» меня не тревожат";
        question_red[4] = "Часто новое вызывает у меня раздражение";
        question_red[5] = "Я человек спокойный и не люблю суетиться";
        question_red[6] = "Я не всегда и не со всеми дружелюбный человек";
        question_red[7] = "Я не очень стараюсь следить за чистотой и порядком";
        question_red[8] = "Я не обращаю внимания на мелкие проблемы";
        question_red[9] = "Я люблю предсказуемость событий";
        question_red[10] = "Мне не нравится быстрый стиль жизни";
        question_red[11] = "Иногда в шутку я задеваю самолюбие других";
        question_red[12] = "Я не очень обязательный человек";
        question_red[13] = "Я редко тревожусь и редко чего-либо боюсь ";
        question_red[14] = "Я не интересуюсь вещами, которые мне не понятны";

        root = findViewById(R.id.root_element2);

        greenText = findViewById(R.id.green_text);
        redText = findViewById(R.id.red_text);

        radio_Min2 = findViewById(R.id.radio_min2);
        radio_Min1 = findViewById(R.id.radio_min1);
        radio_0 = findViewById(R.id.radio_0);
        radio_1 = findViewById(R.id.radio_1);
        radio_2 = findViewById(R.id.radio_2);

        nextBtn = findViewById(R.id.next_btn);

        progressBar = findViewById(R.id.progressBar);

        numberOfTest = findViewById(R.id.number_of_test);

        radioGroup = findViewById(R.id.radio_group);

        greenText.setText(question_green[0]);
        redText.setText(question_red[0]);



        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    if (!radio_Min2.isChecked() && !radio_Min1.isChecked() &&
                            !radio_0.isChecked() && !radio_1.isChecked() && !radio_2.isChecked()) {   // если не выбран ни один из ответов

                        Snackbar.make(root, "Вы не ответили", Snackbar.LENGTH_SHORT).show();

                    } else {

                        if (index > 14) {
                            startActivity(new Intent(TestActivity.this, ResultActivity.class));  // если индекс выходит из question.length() то открыть новый Activity
                        }

                        if (index <= 14) {
                            String indexOfTest = String.valueOf(Integer.parseInt(numberOfTest.getText().toString()) + 1);
                            numberOfTest.setText(indexOfTest);                                           // увеличивать индекс теста

                            greenText.setText("");
                            redText.setText("");

                            greenText.setText(question_green[index]);                                    // показать текущий тест
                            redText.setText(question_red[index]);

                            progressBar.incrementProgressBy(1);
                        }

                        if (radio_Min2.isChecked()) {
                            score[i] = 5;
                            System.out.println(score[i] + " ");
                        } else if (radio_Min1.isChecked()) {
                            score[i] = 4;
                            System.out.println(score[i] + " ");
                        } else if (radio_0.isChecked()) {
                            score[i] = 3;
                            System.out.println(score[i] + " ");
                        } else if (radio_1.isChecked()) {
                            score[i] = 2;
                            System.out.println(score[i] + " ");
                        } else if (radio_2.isChecked()) {
                            score[i] = 1;
                            System.out.println(score[i] + " ");
                        }

                        for (int j = 0; j < score.length; j++) {
                            System.out.print(score[j] + " ");
                        }

                        radioGroup.clearCheck();

                        index++;
                        i++;

                    }

                }

        });


    }
}
