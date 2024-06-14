package com.example.physiofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private EditText emailField, passwordField, usernameField;
    private TextView signinLink;
    private Button signUpButton;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;  // Reference to Firebase Realtime Database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();  // Initialize Realtime Database

        emailField = findViewById(R.id.email);
        passwordField = findViewById(R.id.password);
        usernameField = findViewById(R.id.username);
        signUpButton = findViewById(R.id.sign_up_btn);
        signinLink = findViewById(R.id.signin_link);
        signinLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signUpButton.setOnClickListener(view -> {
            if (isNetworkAvailable()) {
                String email = emailField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();
                String username = usernameField.getText().toString().trim();

                if (password.length() >= 6) {
                    createAccount(email, password, username);
                } else {
                    Toast.makeText(SignUpActivity.this, "Password should be at least 6 characters long", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(SignUpActivity.this, "No internet connection available", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void createAccount(String email, String password, String username) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser firebaseUser = mAuth.getCurrentUser();
                        if (firebaseUser != null) {
                            addUserToDatabase(firebaseUser.getUid(), username, email);
                        }
                    } else {
                        Toast.makeText(SignUpActivity.this, "Registration failed.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void addUserToDatabase(String userId, String username, String email) {
        User newUser = new User(username, email);  // Assuming User constructor takes username and email
        databaseReference.child("users").child(userId).setValue(newUser)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(SignUpActivity.this, "User profile created successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                    finish();
                })
                .addOnFailureListener(e -> Toast.makeText(SignUpActivity.this, "Failed to create user profile", Toast.LENGTH_SHORT).show());
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
}
