package com.example.mockitoexample;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Sorter {
    public List<Event> sortByDate(List<Event> unsortedEvents) {

        List<Event> toSort = new ArrayList<Event>();
        toSort.addAll(unsortedEvents);
        Collections.sort(toSort,new DateComparator());
<<<<<<< HEAD
=======
        
>>>>>>> 8eee0333b712eb5d23bdce45b50183e6b4f8788a
        for (int i = 0; i < toSort.size(); i++)
        {
            Log.d("Test ", "sortByDate: " + toSort.get(i).getEventTime());
        }
<<<<<<< HEAD
=======
        
>>>>>>> 8eee0333b712eb5d23bdce45b50183e6b4f8788a
        return toSort;
    }
}
