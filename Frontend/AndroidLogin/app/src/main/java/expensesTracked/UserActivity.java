package expensesTracked;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import expensesTracked.menu.AddFragment;
import expensesTracked.menu.CalendarFragment;
import expensesTracked.menu.CategoriesFragment;
import expensesTracked.menu.HomeFragment;
import expensesTracked.menu.SettingsFragment;

/**
 * User Activity class
 */
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
    
    /**
     * Public class for selecting the fragment to load based on which item was selected from the navigation bar
     *
     * @param menuItem The selected item from the navigation bar
     * @return True if the fragment to be loaded on the screen is non-null, false otherwise
     */
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
     * @param fragment The fragment layout class that is to be loaded onto the screen
     * @return True if fragment is non-null, false otherwise
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
