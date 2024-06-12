package com.example.physiofit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PhysiotherapistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physiotherapist);

        ImageView profilePicture = findViewById(R.id.profile_picture);
        TextView name = findViewById(R.id.name);
        TextView specialization = findViewById(R.id.specialization);
        RatingBar rating = findViewById(R.id.rating);

        Intent intent = getIntent();
        Physiotherapist physiotherapist = intent.getParcelableExtra("physiotherapist");

        if (physiotherapist != null) {
            profilePicture.setImageResource(physiotherapist.getProfilePicture());
            name.setText(physiotherapist.getName());
            specialization.setText(physiotherapist.getSpecialization());
            rating.setRating(physiotherapist.getRating());
        }
    }
}
