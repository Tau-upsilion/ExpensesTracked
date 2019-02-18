package com.example.hello_android.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hello_android.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Variables
        Button message, next, testVolley, sendMessage, logout;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.buttonMessage);
        next = findViewById(R.id.buttonNext);
        testVolley = findViewById(R.id.buttonVolley);
        sendMessage = findViewById(R.id.buttonSendMessage);
        logout = findViewById(R.id.buttonLogout);

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Hello Android!", Toast.LENGTH_LONG).show();

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openHome = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(openHome);
            }
        });

        testVolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openWorld = new Intent(MainActivity.this, WorldActivity.class);
                startActivity(openWorld);
            }
        });

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent message = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(message);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(logout);
            }
        });
    }
}
