package com.johnsondev.big5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class ResultActivity extends AppCompatActivity {


    private TextView personType;
    private TextView infoPerson;

    private ShareButton shareBtn;

    private RelativeLayout root;

    private ImageView personImg;

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

    private int middleScore;

    private FirebaseDatabase db;
    private FirebaseAuth auth;
    private DatabaseReference reference;
    private FirebaseUser user;

    private Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        personType = findViewById(R.id.person_type);
        infoPerson = findViewById(R.id.info_person);

        root = findViewById(R.id.root3);

        personImg = findViewById(R.id.person_img);

        shareBtn = findViewById(R.id.share_btn);

        midScoreResult1 = new int[5];
        midScoreResult2 = new int[5];
        midScoreResult3 = new int[5];
        midScoreResult4 = new int[5];
        midScoreResult5 = new int[5];

        db =FirebaseDatabase.getInstance();

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

        middleScore = (blockResult1 + blockResult2 + blockResult3 + blockResult4 + blockResult5) / 5;

        // TODO: 26.05.2020 Создать поле Drawable для share, в проверке ниже определить какую картинку присвоить drawable (для картинок создать скриншоты на телефоне)



        if(middleScore > 51){

            root.setBackgroundResource(R.drawable.comandir_background);
            personImg.setImageResource(R.drawable.comandir_image);
            personType.setText("Командир");
            infoPerson.setText("Храбрые, находчивые и сильные духом лидеры, всегда находящие путь - или пробивающие путь. Мыслят стратегически, с планом на все случаи жизни.");
            drawable = getResources().getDrawable(R.drawable.comand_share);

        }else if(middleScore < 51 && middleScore > 41){

            root.setBackgroundResource(R.drawable.avanturist_background);
            personImg.setImageResource(R.drawable.avanturist_image);
            personType.setText("Авантюрист");
            infoPerson.setText("Умные, спонтанные энергичные и очень восприимчивые люди, которые истинно наслаждаются риском. Там где они, никогда не скучно.");
            drawable = getResources().getDrawable(R.drawable.avant_share);

        }else if(middleScore < 41){

            root.setBackgroundResource(R.drawable.logic_background);
            personImg.setImageResource(R.drawable.logic_image);
            personType.setText("Логик");
            infoPerson.setText("Практичные и опирающиеся на факты люди, надежность которых непоколебима. Мыслят логически, проявляют высокий интелект.");
            drawable = getResources().getDrawable(R.drawable.logic_share);

        }

        reference = db.getReference("User");
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();


        reference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("block_1").setValue(blockResult1);
        reference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("block_2").setValue(blockResult2);
        reference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("block_3").setValue(blockResult3);
        reference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("block_4").setValue(blockResult4);
        reference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("block_5").setValue(blockResult5);



        Bitmap image = ((BitmapDrawable) drawable).getBitmap();

        SharePhoto photo = new SharePhoto.Builder().setBitmap(image).build();
        final SharePhotoContent content = new SharePhotoContent.Builder().addPhoto(photo).build();

        shareBtn.setShareContent(content);


        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    ShareDialog.show(ResultActivity.this, content);

            }
        });



    }

}
