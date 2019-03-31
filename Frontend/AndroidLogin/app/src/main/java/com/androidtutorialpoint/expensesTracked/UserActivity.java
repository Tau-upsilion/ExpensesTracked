package com.androidtutorialpoint.expensesTracked;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.androidtutorialpoint.expensesTracked.menu.AddFragment;
import com.androidtutorialpoint.expensesTracked.menu.CalendarFragment;
import com.androidtutorialpoint.expensesTracked.menu.CategoriesFragment;
import com.androidtutorialpoint.expensesTracked.menu.HomeFragment;
import com.androidtutorialpoint.expensesTracked.menu.SettingsFragment;

public class UserActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // Set up navigation bar listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // Variables
        Fragment fragment;

        switch (menuItem.getItemId()) {
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

    /**
     * Helper method to load the fragment layout class that is called in as a parameter
     *
     * @param fragment - the fragment layout class that is to be loaded onto the screen
     * @return true if fragment is non-null, false otherwise
     */
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

            // Return
            return true;
        } else {
            // Return
            return false;
        }

    }

}
