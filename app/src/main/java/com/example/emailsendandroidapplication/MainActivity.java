package com.example.emailsendandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button send;
    EditText message,email,subject;
    String userMessage;
    String Email;
    String userSubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send=findViewById(R.id.buttonSend);
        message=findViewById(R.id.editTextTextMessage);
        subject=findViewById(R.id.editTextSubject);
        email=findViewById(R.id.editTextEmail);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userMessage=message.getText().toString();
                Email=email.getText().toString();
                userSubject=subject.getText().toString();
                sendEmail(Email,userSubject,userMessage);
            }
        });
    }
    public void sendEmail(String Email,String userSubject,String userMessage){
        String[] emailAddress ={Email};
        Intent intent=new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL,emailAddress);
        intent.putExtra(Intent.EXTRA_SUBJECT,userSubject);
        intent.putExtra(Intent.EXTRA_TEXT,userMessage);
        startActivity(Intent.createChooser(intent,"Email Send"));
    }

}