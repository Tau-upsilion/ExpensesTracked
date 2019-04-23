package expensesTracked.menu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import expensesTracked.AppSingleton;
import expensesTracked.Expenses;
import expensesTracked.R;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CategoriesFragment extends Fragment {
    
    private static final String URL_FOR_LISTING = "http://cs309-yt-7.misc.iastate.edu:8080/secure/expenses/all";  // TODO - change
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Variables
        View v = inflater.inflate(R.layout.fragment_categories, null);
        String strDate = DateFormat.getDateInstance(1).format(new Date());
        TextView date;
        
        // Initializations
        date = v.findViewById(R.id.cat_date);
//        TableLayout catList = v.findViewById(R.id.cat_list);
//        catList.setVisibility(View.VISIBLE);
        date.setText(strDate.substring(0, strDate.indexOf(" ")));   // Month
    
        // Get the income/expenses list
        listIncomeAndExpenses(AppSingleton.getInstance(getActivity()).getToken(getActivity(), "token"));
        
        // Return
        return v;
    }
    
    private void listIncomeAndExpenses(final String token)
    {
        // Tag used to cancel the request
        String cancel_req_tag = "listed";
        
        Map<String, String> params = new HashMap<>();
        params.put("token", token);
        
        JSONObject req = new JSONObject(params);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL_FOR_LISTING, req,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            boolean error = response.getBoolean("error");
                            if (!error) {
                                Toast.makeText(getActivity(), "Successful!", Toast.LENGTH_SHORT).show();
                                JSONArray expenses = response.getJSONArray("allexpenses");
                                
                                // TODO - Add the expenses to the page
                                getExpenses(expenses);
                            }
                            
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "An error occurred while getting your information.", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });
        
        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjectRequest, cancel_req_tag);
    }
    
    private void getExpenses(JSONArray expenses) {
    
    
    }

}
