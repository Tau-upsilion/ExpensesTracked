package com.example.hello_android.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;

import com.example.hello_android.R;
import com.example.hello_android.net_utils.ImageRequest;
import com.example.hello_android.net_utils.JsonRequest;
import com.example.hello_android.net_utils.StringRequest;

public class WorldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Variables
        Button back, stringRequest, jsonRequest, imageRequest;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);

        back = findViewById(R.id.buttonBack);
        stringRequest = findViewById(R.id.buttonStringRequest);
        jsonRequest = findViewById(R.id.buttonJsonRequest);
        imageRequest = findViewById(R.id.buttonImageRequest);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBackHome = new Intent(WorldActivity.this, MainActivity.class);
                startActivity(goBackHome);
            }
        });

        stringRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goString = new Intent(WorldActivity.this, StringRequest.class);
                startActivity(goString);
            }
        });

        jsonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goJson = new Intent(WorldActivity.this, JsonRequest.class);
                startActivity(goJson);
            }
        });

        imageRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goImage = new Intent(WorldActivity.this, ImageRequest.class);
                startActivity(goImage);
            }
        });

    }

}
