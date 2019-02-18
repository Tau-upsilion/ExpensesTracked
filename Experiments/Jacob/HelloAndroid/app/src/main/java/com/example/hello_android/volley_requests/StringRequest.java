package com.example.hello_android.volley_requests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hello_android.R;

public class StringRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Variables
        Button stringRequest;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_request);

        stringRequest = findViewById(R.id.buttonStringRequest);

        stringRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
