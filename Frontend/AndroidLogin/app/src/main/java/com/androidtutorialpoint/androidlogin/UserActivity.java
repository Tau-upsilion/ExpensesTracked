package com.androidtutorialpoint.androidlogin;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class UserActivity extends AppCompatActivity {

    private static final String TAG = "UserActivity";

    private TextView greetingTextView;
    private Button btnLogOut;
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch(menuItem.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_categories:
                    return true;
                case R.id.navigation_add:
                    return true;
                case R.id.navigation_calendar:
                    return true;
                case R.id.navigation_settings:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Bundle bundle = getIntent().getExtras();
        String user = bundle.getString("username");
        greetingTextView = (TextView) findViewById(R.id.greeting_text_view);
        btnLogOut = (Button) findViewById(R.id.logout_button);
        greetingTextView.setText("Hello "+ user);

        // Set up navigation bar listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        // Set up logout button listener
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }
}
