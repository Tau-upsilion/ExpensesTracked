package com.androidtutorialpoint.expensesTracked.menu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.androidtutorialpoint.expensesTracked.R;

public class CalendarFragment extends Fragment {
    // Instance variables
    String selectedDate;
    TextView date;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Variables
        View v = inflater.inflate(R.layout.fragment_calendar, null);
        CalendarView calendar;

        // Initializations
        calendar = v.findViewById(R.id.cal_calendar);
        date = v.findViewById(R.id.cal_date);

        // OnDateChange Listener
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                switch (month) {
                    case 0:
                        selectedDate = "Jan " + dayOfMonth + ", " + year;
                        break;
                    case 1:
                        selectedDate = "Feb " + dayOfMonth + ", " + year;
                        break;
                    case 2:
                        selectedDate = "Mar " + dayOfMonth + ", " + year;
                        break;
                    case 3:
                        selectedDate = "Apr " + dayOfMonth + ", " + year;
                        break;
                    case 4:
                        selectedDate = "May " + dayOfMonth + ", " + year;
                        break;
                    case 5:
                        selectedDate = "June " + dayOfMonth + ", " + year;
                        break;
                    case 6:
                        selectedDate = "July " + dayOfMonth + ", " + year;
                        break;
                    case 7:
                        selectedDate = "Aug " + dayOfMonth + ", " + year;
                        break;
                    case 8:
                        selectedDate = "Sept " + dayOfMonth + ", " + year;
                        break;
                    case 9:
                        selectedDate = "Oct " + dayOfMonth + ", " + year;
                        break;
                    case 10:
                        selectedDate = "Nov " + dayOfMonth + ", " + year;
                        break;
                    case 11:
                        selectedDate = "Dec " + dayOfMonth + ", " + year;
                        break;
                    default:
                        selectedDate = "Jan 1, 1970";
                        break;
                }

                // Set the text of the TextView to the date
                date.setText(selectedDate);
            }
        });

        // Return
        return v;
    }

}
