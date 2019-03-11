package com.androidtutorialpoint.androidlogin.menu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.androidtutorialpoint.androidlogin.R;

public class AddFragment extends Fragment {
    // Instance variables
    private long categoryId = -1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Variables
        View v = inflater.inflate(R.layout.fragment_add, null);
        AppCompatSpinner dropDown = v.findViewById(R.id.add_dropdown);

        // Spinner item selected listener
        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                categoryId = id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Return
        return v;
    }

}
