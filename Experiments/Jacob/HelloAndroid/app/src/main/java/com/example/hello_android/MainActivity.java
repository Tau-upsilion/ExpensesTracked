package com.example.hello_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button message, next, helloWorld, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.buttonMessage);
        next = findViewById(R.id.buttonNext);
        helloWorld = findViewById(R.id.buttonHello);
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

        helloWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openWorld = new Intent(MainActivity.this, WorldActivity.class);
                startActivity(openWorld);
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
