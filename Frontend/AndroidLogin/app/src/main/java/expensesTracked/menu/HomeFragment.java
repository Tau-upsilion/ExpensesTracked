package expensesTracked.menu;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import expensesTracked.AppSingleton;
import expensesTracked.R;

public class HomeFragment extends Fragment {
    // Instance variables
    private float totalAmount;
    private TextView amount_text;
    private static final String URL_FOR_LISTING = "http://cs309-yt-7.misc.iastate.edu:8080/secure/expenses/all";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Variables
        View v = inflater.inflate(R.layout.fragment_home, null);
        String strDate = DateFormat.getDateInstance(1).format(new Date());
        TextView date;
        
        // Initializations
        date = v.findViewById(R.id.home_date);
        date.setText(strDate);
        amount_text = v.findViewById(R.id.textView);
    
        // List expenses total
        listTotalAmount(AppSingleton.getInstance(getActivity()).getToken(getActivity(), "token"));
        
        // Return
        return v;
    }
    
    private void listTotalAmount(final String token) {
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
                            float amount = 0;
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);

                                        amount += Float.parseFloat(o.getString("amount"));
                            }
                            
                            totalAmount = amount;
                            amount_text.setText("This is your total spending: $"+Float.toString(totalAmount));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
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
