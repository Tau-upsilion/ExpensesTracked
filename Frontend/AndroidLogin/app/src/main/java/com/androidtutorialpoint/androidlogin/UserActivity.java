package com.androidtutorialpoint.androidlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidtutorialpoint.androidlogin.menu.AddFragment;
import com.androidtutorialpoint.androidlogin.menu.CalendarFragment;
import com.androidtutorialpoint.androidlogin.menu.CategoriesFragment;
import com.androidtutorialpoint.androidlogin.menu.HomeFragment;
import com.androidtutorialpoint.androidlogin.menu.SettingsFragment;

import java.text.DateFormat;
import java.util.Date;

public class UserActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // Variables
        TextView greetingTextView;

        // Initializations
        Bundle bundle = getIntent().getExtras();
//        String user = bundle.getString("username");                           // Commented out bc causes app to crash
        greetingTextView = (TextView) findViewById(R.id.greeting_text_view);
//        greetingTextView.setText("Hello "+ user);                             // Commented out bc causes app to crash

        // Set up navigation bar listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

            // Return
            return true;
        }
        else
        {
            // Return
            return false;
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // Variables
        Fragment fragment;

        switch(menuItem.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_categories:
                fragment = new CategoriesFragment();
                break;
            case R.id.navigation_add:
                fragment = new AddFragment();
                break;
            case R.id.navigation_calendar:
                fragment = new CalendarFragment();
                break;
            case R.id.navigation_settings:
                fragment = new SettingsFragment();
                break;
            default:
                fragment = null;
                break;
        }

        // Return
        return loadFragment(fragment);
    }
}
