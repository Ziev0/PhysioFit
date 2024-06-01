package com.example.physiofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;

public class SignUpActivity extends AppCompatActivity {

    Button signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpButton = findViewById(R.id.sign_up_btn);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(SignUpActivity.this, SignInActivity.class);
                SignUpActivity.this.startActivity(mainIntent);
                SignUpActivity.this.finish();
            }
        });
    }
}