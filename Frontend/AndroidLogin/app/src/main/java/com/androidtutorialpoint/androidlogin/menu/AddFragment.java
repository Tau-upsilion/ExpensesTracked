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
import android.widget.ArrayAdapter;
import android.widget.Button;

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
        Button add = v.findViewById(R.id.add_addButton);

        // OnClick listener
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO - add expense to server
            }
        });

        // OnItemSelected listener
        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                categoryId = id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Create an ArrayAdapter using the string array and spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.starting_categories,
                android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        dropDown.setAdapter(adapter);

        // Return
        return v;
    }

}
