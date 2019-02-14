package com.example.networkprotocolmilestone0;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText password2;
    private TextView characters;
    private Button login;
    private Button register;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//        //progressDialog = new ProgressDialog(this);
//        firebaseAuth = FirebaseAuth.getInstance();
//        login = (Button) findViewById(R.id.login);
//        register = (Button) findViewById(R.id.register);
//        username = (EditText) findViewById(R.id.username);
//        email = (EditText) findViewById(R.id.email);
//        password = (EditText) findViewById(R.id.password);
//        password2 = (EditText) findViewById(R.id.password2);
//        characters = findViewById(R.id.characters);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent3 = new Intent(Register.this, MainActivity.class);
//                startActivity(intent3);
//            }
//        });
////        register.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent4 = new Intent(Register.this, MainActivity.class);
////                startActivity(intent4);
////            }
////        });
//    }
////    private void onClick(View view){
////
////            String user_email = email.getText().toString().trim();
////            String user_pass = password.getText().toString().trim();
////            firebaseAuth.createUserWithEmailAndPassword(user_email,user_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
////                @Override
////                public void onComplete(@NonNull Task<AuthResult> task) {
////                    if(task.isSuccessful()) {
////                        Toast.makeText(Register.this, "registration successful", Toast.LENGTH_SHORT).show();
////                        startActivity(new Intent(Register.this,MainActivity.class));
////                    }
////                    else{
////                        Toast.makeText(Register.this, "registration failed", Toast.LENGTH_SHORT).show();
////                    }
////                }
////            });
//
//    //        if(TextUtils.isEmpty(editemail)){
////            Toast.makeText(this,"Please enter email. ",Toast.LENGTH_SHORT).show();
////            return;
////        }
////        if(TextUtils.isEmpty(editpass)){
////            Toast.makeText(this,"Please enter password. ",Toast.LENGTH_SHORT).show();
////            return;
////        }
////        progressDialog.setMessage("Registering user...");
////        progressDialog.show();
////        firebaseAuth.createUserWithEmailAndPassword(editemail,editpass)
////                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
////                    @Override
////                    public void onComplete(@NonNull Task<AuthResult> task) {
////
////                            if(task.isSuccessful()){
////                                Toast.makeText(Register.this,"registered successfully",Toast.LENGTH_SHORT).show();
////                            }
////                            else {
////                                Toast.makeText(Register.this,"couldn't register please try again",Toast.LENGTH_SHORT).show();
////                            }
////
////                    }
////                });
////    }
////}
////
////
////}
//    public void onClick(View view) {
//        if (view == register) {
//            userRegister();
//        }
////        if (view == login) {
////            userRegister();
////        }
//
//    }
//
//
//    private void userRegister() {
//        String editusername = username.getText().toString().trim();
//        String editpass = password.getText().toString().trim();
//        if (TextUtils.isEmpty(editusername)) {
//            Toast.makeText(this, "Please enter email. ", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (TextUtils.isEmpty(editpass)) {
//            Toast.makeText(this, "Please enter password. ", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        progressDialog.setMessage("Registering user...");
//        progressDialog.show();
//        firebaseAuth.signInWithEmailAndPassword(editusername, editpass)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        progressDialog.dismiss();
//                        if (task.isSuccessful()) {
//                            finish();
//                            startActivity(new Intent(getApplicationContext(), List.class));
//                        } else {
//                            Toast.makeText(Register.this, "couldn't register please try again", Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                });
//    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance();
//        if(firebaseAuth.getCurrentUser() !=null){
//            startActivity(new Intent(getApplicationContext(), List.class));
//            finish();
        //}
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        password2 = (EditText) findViewById(R.id.password2);
        register = (Button) findViewById(R.id.register);
        characters = (TextView) findViewById(R.id.characters);
        email = (EditText) findViewById(R.id.email);
        final String editmail = email.getText().toString().trim();
        final String editpass = password.getText().toString().trim();
        final String editusername = username.getText().toString().trim();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Register.this, MainActivity.class);
                startActivity(intent3);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Intent intent5 = new Intent(Register.this, List.class);
                                    startActivity(intent5);

                                } else {
                                    Toast.makeText(Register.this, "couldn't register please try again", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                Intent intent1 = new Intent(Register.this, MainActivity.class);
                startActivity(intent1);
            }
        });


//        progressDialog.setMessage("Registering user...");
//        progressDialog.show();

    }


    //private void userLogin(){

//        firebaseAuth.signInWithEmailAndPassword(editusername,editpass)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        progressDialog.dismiss();
//                        if(task.isSuccessful()){
//                            finish();
//                            startActivity(new Intent(getApplicationContext(), List.class));
//                        }
//                        else {
//                            Toast.makeText(MainActivity.this,"couldn't register please try again",Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                });
    //}
//    @Override
//    public void onClick(View view){
//        if(view==register){
//            userLogin();
//        }
//
//    }


}