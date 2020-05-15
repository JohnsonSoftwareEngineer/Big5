package com.johnsondev.big5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.johnsondev.big5.dbModels.User;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnRegister;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;

    RelativeLayout root;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.signInButton);
        btnRegister = findViewById(R.id.registerButton);

        root = findViewById(R.id.root_element);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("User");



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterWindow();
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSingInWindow();
            }
        });
    }

    private void showSingInWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Войти");
        dialog.setMessage("Введите данные для входа");

        LayoutInflater inflater = LayoutInflater.from(this);
        View signInWindow = inflater.inflate(R.layout.sign_in_window,null);
        dialog.setView(signInWindow);

        final MaterialEditText email = signInWindow.findViewById(R.id.emailField);
        final MaterialEditText password = signInWindow.findViewById(R.id.passField);

        dialog.setNegativeButton("Назад", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    Snackbar.make(root,"Введите ваш email", Snackbar.LENGTH_SHORT).show(); // маленкое всплывающее окно
                    return;
                }
                if(password.getText().toString().length() < 5){
                    Snackbar.make(root,"Введите пароль который более 5 символов", Snackbar.LENGTH_SHORT).show(); // маленкое всплывающее окно
                    return;
                }

                // вход:

                auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Snackbar.make(root,"SignIn is succesful!",Snackbar.LENGTH_SHORT).show();

                                                    // Update of block

//                                DatabaseReference databaseReference = db.getReference("User");
//                                databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("block_1").setValue(1);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(root,"Ошибка авторизации",Snackbar.LENGTH_SHORT).show();
                    }
                });
            }
        });
        dialog.show();
    }


    private void showRegisterWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Зарегистрироваться");
        dialog.setMessage("Введите данные для регистрации");

        LayoutInflater inflater = LayoutInflater.from(this);
        View registerWindow = inflater.inflate(R.layout.register_window,null);
        dialog.setView(registerWindow);

        final MaterialEditText email = registerWindow.findViewById(R.id.regEmailField);
        final MaterialEditText password = registerWindow.findViewById(R.id.regPassField);
        final MaterialEditText name = registerWindow.findViewById(R.id.regNameField);
        final MaterialEditText phone = registerWindow.findViewById(R.id.regPhoneField);

        dialog.setNegativeButton("Назад", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("Далее", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    Snackbar.make(root,"Введите ваш email", Snackbar.LENGTH_SHORT).show(); // маленкое всплывающее окно
                    return;
                }
                if(TextUtils.isEmpty(name.getText().toString())){
                    Snackbar.make(root,"Введите ваше имя", Snackbar.LENGTH_SHORT).show(); // маленкое всплывающее окно
                    return;
                }
                if(TextUtils.isEmpty(phone.getText().toString())){
                    Snackbar.make(root,"Введите ваш телефон", Snackbar.LENGTH_SHORT).show(); // маленкое всплывающее окно
                    return;
                }
                if(password.getText().toString().length() < 5){
                    Snackbar.make(root,"Введите пароль который более 5 символов", Snackbar.LENGTH_SHORT).show(); // маленкое всплывающее окно
                    return;
                }

                // registering:

                auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {  //когда пользователь успешно добавлен в бд
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                User user = new User();
                                user.setEmail(email.getText().toString());
                                user.setName(name.getText().toString());
                                user.setPassword(password.getText().toString());
                                user.setPhone(phone.getText().toString());
                                user.setBlock_1(0);
                                user.setBlock_2(0);
                                user.setBlock_3(0);
                                user.setBlock_4(0);
                                user.setBlock_5(0);


                                users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Snackbar.make(root,"Регистрация успешна!", Snackbar.LENGTH_SHORT).show();
                                            }
                                        });
//                                users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Block").setValue(user.getBlock_1());
//                                users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Block").setValue(user.getBlock_2());
                            }

                        });
            }
        });
        dialog.show();





    }



}



