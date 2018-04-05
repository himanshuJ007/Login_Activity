package com.technicalrj.task;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.jar.Attributes;

public class LoginActivity extends AppCompatActivity {
    EditText Name;
    EditText password;
    private FirebaseAuth firebaseAuth;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("LOGIN");

        Name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user != null){
            finish();
            startActivity(new Intent(LoginActivity.this, SecondActivity.class));
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), password.getText().toString());
            }
        });
    }
    private void validate(String userName, String userPassword) {



        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, SecondActivity.class));
                  //  checkEmailVerification();
                }else{
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();



                }
            }
        });


    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user != null){
            finish();
            startActivity(new Intent(LoginActivity.this, SecondActivity.class));
        }

    }
    public void goSignup(View view){
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}
