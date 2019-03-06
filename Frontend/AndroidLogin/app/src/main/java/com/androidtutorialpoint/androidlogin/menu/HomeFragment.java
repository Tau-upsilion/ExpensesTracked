package com.androidtutorialpoint.androidlogin.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidtutorialpoint.androidlogin.LoginActivity;
import com.androidtutorialpoint.androidlogin.R;
import com.androidtutorialpoint.androidlogin.UserActivity;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Variables
        View v = inflater.inflate(R.layout.fragment_home, null);


        // Return
        return v;
    }

}
