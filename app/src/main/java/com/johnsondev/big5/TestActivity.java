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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //   questions

        question_green = new String[75];
        question_red = new String[75];
        score = new int[75];

        //green

        question_green[0] = "Мне нравится заниматься физкультурой";                         //  -2
        question_green[1] = "Люди считают меня отзывчивым и доброжелательным человеком";    //  1
        question_green[2] = "Я во всем ценю чистоту и порядок";                             //  2
        question_green[3] = "Меня часто беспокоит мысль, что что-нибудь может случиться";   //  0
        question_green[4] = "Все новое вызывает у меня интерес";                            //  -1
        question_green[5] = "Если я ничем не занят, то это меня беспокоит";                 //  -2
        question_green[6] = "Я стараюсь проявлять дружелюбие ко всем людям";                //  1
        question_green[7] = "Моя комната всегда аккуратно прибрана";                        //  2
        question_green[8] = "Иногда я расстраиваюсь из-за пустяков";                        //  0
        question_green[9] = "Мне нравятся неожиданности";                                   //  0
        question_green[10] = "Я не могу долго оставаться в неподвижности";                  //  1
        question_green[11] = "Я тактичен по отношения к другим людям";                      //  -1
        question_green[12] = "Я методичен и пунктуален во всем ";                           //  -2
        question_green[13] = "Мои чувства легко уязвимы и ранимы";                          //  2
        question_green[14] = "Мне не интересно, когда ответ ясен заранее";                  //  1

        question_green[15] = " Я люблю, чтобы другие быстро выполняли мои распоряжения";            //  -2
        question_green[16] = "Я уступчивый и склонный к компромиссам человек";                      //  1
        question_green[17] = "Я проявляю настойчивость, решая трудную задачу";                      //  2
        question_green[18] = "В трудных ситуациях я весь сжимаюсь от напряжения";                   //  0
        question_green[19] = "У меня очень живое воображение";                                      //  -1
        question_green[20] = "Мне часто приходится быть лидером, проявлять инициативу";             //  -2
        question_green[21] = "Я всегда готов оказать помощь и разделить чужие трудности";           //  1
        question_green[22] = "Я очень старательный во всех делах человек";                          //  2
        question_green[23] = " У меня часто выступает холодный пот и дрожат руки";                  //  0
        question_green[24] = "Мне нравится мечтать";                                                //  0
        question_green[25] = "Часто случается, что я руковожу, отдаю распоряжения другим людям";    //  1
        question_green[26] = "Я предпочитаю сотрудничать с другими, чем соперничать";               //  -1
        question_green[27] = "Я серьезно и прилежно отношусь к работе";                             //  -2
        question_green[28] = " В необычной обстановке я часто нервничаю";                           //  2
        question_green[29] = " Иногда я погружаюсь в глубокие размышления";                         //  1

        question_green[30] = "Мне нравится общаться с незнакомыми людьми";
        question_green[31] = " Большинство людей добры от природы";
        question_green[32] = "Люди часто доверяют мне ответственные дела";
        question_green[33] = "Иногда я чувствую себя одиноко, тоскливо и все валится из рук";
        question_green[34] = "Я хорошо знаю, что такое красота и элегантность";
        question_green[35] = " Мне нравится приобретать новых друзей и знакомых";
        question_green[36] = "Люди, с которыми я общаюсь, обычно мне нравятся ";
        question_green[37] = " Я требователен и строг в работе";
        question_green[38] = "Когда я сильно расстроен, у меня тяжело на душе";
        question_green[39] = " Музыка способна так захватить меня, что я теряю чувство времени";
        question_green[40] = "Я люблю находиться в больших и веселых компаниях";
        question_green[41] = "Большинство людей честные, и им можно доверять ";
        question_green[42] = "Я обычно работаю добросовестно";
        question_green[43] = "Я легко впадаю в депрессию";
        question_green[44] = "Настоящее произведение искусства вызывает у меня восхищение ";

        question_green[45] = " «Болея» на спортивных соревнованиях, я забываю обо всем";
        question_green[46] = "Я стараюсь проявлять чуткость, когда имею дело с людьми ";
        question_green[47] = "Я редко делаю необдуманно то, что хочу сделать";
        question_green[48] = " У меня много слабостей и недостатков";
        question_green[49] = " Я хорошо понимаю свое душевное состояние";
        question_green[50] = "Я часто игнорирую сигналы, предупреждающие об опасности";
        question_green[51] = " Радость других я разделяю как собственную";
        question_green[52] = "Я обычно контролирую свои чувства и желания ";
        question_green[53] = "Если я терплю неудачу, то обычно обвиняю себя";
        question_green[54] = "Я верю, что чувства делают мою жизнь содержательнее ";
        question_green[55] = " Мне нравятся карнавальные шествия и демонстрации";
        question_green[56] = "Я стараюсь поставить себя на место другого человека, чтобы его понять";
        question_green[57] = "В магазине я обычно долго выбираю то, что надумал купить";
        question_green[58] = "Иногда я чувствую себя жалким человеком";
        question_green[59] = "Я легко «вживаюсь» в переживания вымышленного героя";

        question_green[60] = "Я чувствую себя счастливым, когда на меня обращают внимание";
        question_green[61] = "В каждом человеке есть нечто, за что его можно уважать";
        question_green[62] = "Обычно я хорошо думаю, прежде чем действую";
        question_green[63] = "Часто у меня бывают взлеты и падения настроения";
        question_green[64] = "Иногда я чувствую себя фокусником, подшучивающим над людьми ";
        question_green[65] = " Я привлекателен для лиц противоположного пола";
        question_green[66] = " Я всегда стараюсь быть добрым и внимательным с каждым человеком";
        question_green[67] = " Перед путешествием я намечаю точный план";
        question_green[68] = "Мое настроение легко меняется на противоположное ";
        question_green[69] = " Я думаю, что жизнь – это азартная игра";
        question_green[70] = "Мне нравится выглядеть вызывающе";
        question_green[71] = "Некоторые говорят, что я снисходителен к окружающим";
        question_green[72] = "Я точно и методично выполняю свою работу";
        question_green[73] = "Иногда я бываю настолько взволнован, что даже плачу";
        question_green[74] = "Иногда я чувствую, что могу открыть в себе нечто новое ";


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

        question_red[15] = "Я не спеша выполняю чужие распоряжения";
        question_red[16] = "Я люблю поспорить с окружающими ";
        question_red[17] = "Я не очень настойчивый человек";
        question_red[18] = "Я могу расслабиться в любой ситуации";
        question_red[19] = "Я всегда предпочитаю реально смотреть на мир";
        question_red[20] = "Я скорее подчиненный, чем лидер ";
        question_red[21] = "Каждый должен уметь позаботиться о себе ";
        question_red[22] = "Я не очень усердствую на работе ";
        question_red[23] = "Я редко испытывал напряжение, сопровождаемое дрожью в теле";
        question_red[24] = "Я редко увлекаюсь фантазиями";
        question_red[25] = "Я предпочитаю, чтобы кто-то другой брал в свои руки руководство";
        question_red[26] = "Без соперничества общество не могло бы развиваться";
        question_red[27] = "Я стараюсь не брать дополнительные обязанности на работе ";
        question_red[28] = "Я легко привыкаю к новой обстановке";
        question_red[29] = "Я не люблю тратить свое время на размышления ";

        question_red[30] = "Я не очень общительный человек";
        question_red[31] = " Я думаю, что жизнь делает некоторых людей злыми";
        question_red[32] = "Некоторые считают меня безответственным ";
        question_red[33] = "Часто, что-либо делая, я так увлекаюсь, что забываю обо всем";
        question_red[34] = "Мое представление о красоте такое же, как и у других ";
        question_red[35] = "Я предпочитаю иметь только несколько надежных друзей ";
        question_red[36] = "Есть такие люди, которых я не люблю";
        question_red[37] = " Иногда я пренебрегаю своими обязанностями";
        question_red[38] = "У меня очень редко бывает мрачное настроение";
        question_red[39] = " Драматическое искусство и балет кажутся мне скучными";
        question_red[40] = "Я предпочитаю уединение";
        question_red[41] = "Иногда я отношусь подозрительно к другим людям ";
        question_red[42] = "Люди часто находят в моей работе ошибки";
        question_red[43] = "Мне невозможно испортить настроение ";
        question_red[44] = "Я редко восхищаюсь совершенством настоящего произведения искусства";

        question_red[45] = "Я не понимаю, почему люди занимаются опасными видами спорта";
        question_red[46] = "Иногда мне нет дела до интересов других людей";
        question_red[47] = "Я предпочитаю принимать решения быстро";
        question_red[48] = "У меня высокая самооценка";
        question_red[49] = " Мне кажется, что другие люди менее чувствительны, чем я";
        question_red[50] = "Я предпочитаю избегать опасных ситуаций ";
        question_red[51] = "Я не всегда разделяю чувства других людей";
        question_red[52] = "Мне трудно сдерживать свои желания";
        question_red[53] = "Мне часто «везет», и обстоятельства редко бывают против меня";
        question_red[54] = " Я редко обращаю внимание на чужие переживания";
        question_red[55] = "Мне не нравится находиться в многолюдных местах ";
        question_red[56] = " Я не стремлюсь понять все нюансы переживаний других людей";
        question_red[57] = "Иногда я покупаю вещи импульсивно";
        question_red[58] = " Обычно я чувствую себя нужным человеком ";
        question_red[59] = "Приключения киногероя не могут изменить мое душевное состояние ";

        question_red[60] = "Я скромный человек и стараюсь не выделяться среди людей ";
        question_red[61] = " Я еще не встречал человека, которого можно было бы уважать";
        question_red[62] = "Я не люблю продумывать заранее результаты своих поступков";
        question_red[63] = "Обычно у меня ровное настроение";
        question_red[64] = "Люди часто называют меня скучным, но надежным человеком";
        question_red[65] = "Некоторые считают меня обычным и неинтересным человеком";
        question_red[66] = "Некоторые люди думают, что я самонадеянный и эгоистичный";
        question_red[67] = "Я не могу понять, зачем люди строят такие детальные планы";
        question_red[68] = "Я всегда спокоен и уравновешен";
        question_red[69] = "Жизнь – это опыт, передаваемый последующим поколениям";
        question_red[70] = " В обществе я обычно не выделяюсь поведением и модной одеждой";
        question_red[71] = "Говорят, что я часто хвастаюсь своими успехами";
        question_red[72] = "Я предпочитаю «плыть по течению», доверяя своей интуиции";
        question_red[73] = "Меня трудно вывести из себя";
        question_red[74] = "Я не хотел бы ничего в себе менять";




        // TODO: 21.05.2020 добавить остальные 4 блоков по 15 вопросов и изменить условия для индексов и размеры масивов

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

                        if (index > 74) {
                            startActivity(new Intent(TestActivity.this, ResultActivity.class));  // если индекс выходит из question.length() то открыть новый Activity
                        }

                        if (index <= 74) {
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
