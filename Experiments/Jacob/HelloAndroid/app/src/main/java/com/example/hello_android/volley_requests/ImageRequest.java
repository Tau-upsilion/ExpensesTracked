package com.example.hello_android.volley_requests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hello_android.R;

public class ImageRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Variables
        Button imageRequest;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_request);

        imageRequest = findViewById(R.id.buttonImageRequest);

        imageRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
