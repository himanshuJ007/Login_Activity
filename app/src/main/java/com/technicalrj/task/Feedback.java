package com.technicalrj.task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Feedback extends AppCompatActivity {
    private EditText userName,userEmail, usermessage;
    private Button regButton;
    private TextView userLogin;

    String email, name, message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        setTitle("Feedback");

        userName = (EditText)findViewById(R.id.Fname);
        userEmail = (EditText)findViewById(R.id.Femail);
        usermessage = (EditText)findViewById(R.id.Fmessage);
    }
    public void gosubmit(View view){
        if(validate()){
            Toast.makeText(Feedback.this, "ThankYou for Feedback", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Feedback.this, SecondActivity.class));
        }
        else {
            Toast.makeText(Feedback.this, "Cmoplete The Details", Toast.LENGTH_SHORT).show();
        }
    }
    private Boolean validate(){
        Boolean result = false;

        name = userName.getText().toString();
        email = userEmail.getText().toString();
        message = usermessage.getText().toString();


        if(name.isEmpty() ||  email.isEmpty() || message.isEmpty()){
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }

        return result;
    }
}
