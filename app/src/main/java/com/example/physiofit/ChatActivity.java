package com.example.physiofit;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText messageInput;
    private ImageView sendButton, attachButton, cameraButton, voiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerView = findViewById(R.id.recyclerView);
        messageInput = findViewById(R.id.messageInput);
        sendButton = findViewById(R.id.sendButton);
        attachButton = findViewById(R.id.attachButton);
        cameraButton = findViewById(R.id.cameraButton);
        voiceButton = findViewById(R.id.voiceButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // You can set an adapter here to display chat messages
    }
}