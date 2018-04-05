package com.technicalrj.task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {

    Button logout;
    Button feedback;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("App Content");

        firebaseAuth = FirebaseAuth.getInstance();
        logout=findViewById(R.id.logout);
        feedback=findViewById(R.id.feedback);


    }
    public void gologout(View view){

        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(SecondActivity.this, LoginActivity.class));

    }

    public void gofeedback(View view){
        startActivity(new Intent(SecondActivity.this, Feedback.class));
    }

}
