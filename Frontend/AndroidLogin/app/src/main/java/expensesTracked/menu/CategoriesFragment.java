package expensesTracked.menu;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import expensesTracked.AppSingleton;
import expensesTracked.ListItem;
import expensesTracked.MyAdapter;
import expensesTracked.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriesFragment extends Fragment {
    
    private static final String URL_FOR_LISTING = "http://cs309-yt-7.misc.iastate.edu:8080/secure/expenses/all";  // TODO - change
    //private static final String URL_FOR_LISTING = "http://10.0.2.2:8080/secure/expenses/all";
    
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Variables
        View v = inflater.inflate(R.layout.fragment_categories, container, false);
        
        // Initializations
    
        // Get the income/expenses list
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        listItems = new ArrayList<>();
        listIncomeAndExpenses(AppSingleton.getInstance(getActivity()).getToken(getActivity(), "token"));
        
        // Return
        return v;
    }
    
    private void listIncomeAndExpenses(final String token) {
        final ProgressDialog progressDialog = new ProgressDialog(this.getContext());
        progressDialog.setMessage("loading...");
        progressDialog.show();
        String cancel_req_tag = "listed";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_FOR_LISTING,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        
                        try {
                            Log.d("RESPONSE FROM SERVER", response);
                            JSONObject jsonObject = new JSONObject(response);
                            Log.d("JSON OBJECT",jsonObject.toString());
                            JSONArray array = jsonObject.getJSONArray("expenses");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);
                                ListItem item = new ListItem(
                                        o.getString("name"),
                                        o.getString("description"),
                                        o.getString("amount")
                                );
                                
                                listItems.add(item);
                            }
                            
                            Log.d("JSON OBJECT RETURNED", listItems.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        
                        adapter = new MyAdapter(listItems, getContext());
                        recyclerView.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> header = new HashMap<>();
                header.put("authorization", "Bearer " + AppSingleton.getInstance(getContext()).getToken(getContext(), "TOKEN"));
                Log.d("THIS IS THE HEADER:", header.toString());
                return header;
            }
        };
        
        AppSingleton.getInstance(getContext()).addToRequestQueue(stringRequest, cancel_req_tag);
    }
}
