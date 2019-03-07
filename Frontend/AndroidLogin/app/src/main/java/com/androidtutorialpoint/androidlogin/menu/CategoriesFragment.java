package com.androidtutorialpoint.androidlogin.menu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidtutorialpoint.androidlogin.R;

import java.text.DateFormat;
import java.util.Date;

public class CategoriesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Variables
        View v = inflater.inflate(R.layout.fragment_categories, null);
        String strDate = DateFormat.getDateInstance().format(new Date());
        TextView date;

        // Initializations
        date = v.findViewById(R.id.cat_date);
        date.setText(strDate);

        // Return
        return v;
    }

}
