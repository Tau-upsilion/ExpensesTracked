package com.androidtutorialpoint.expensesTracked.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidtutorialpoint.expensesTracked.LoginActivity;
import com.androidtutorialpoint.expensesTracked.R;

public class SettingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Variables
        View v = inflater.inflate(R.layout.fragment_settings, null);
        Button btnSignout;

        // Find ids
        btnSignout = v.findViewById(R.id.btn_logout);

        // On click listeners
        btnSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logoutIntent = new Intent(getActivity(), LoginActivity.class);
                startActivity(logoutIntent);
            }
        });


        // Return
        return v;
    }

}
