package expensesTracked.menu;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import expensesTracked.AppSingleton;
import expensesTracked.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Add Fragment class
 */
public class AddFragment extends Fragment {
    // Instance variables
    private long categoryId = -1;
    private static final String TAG = "Adding expenses";
    //private static final String URL_FOR_ADDING = "http://10.0.2.2:8080/secure/expenses/add";
    private static final String URL_FOR_ADDING = "http://cs309-yt-7.misc.iastate.edu:8080/secure/expenses/add";
    private ProgressDialog progressDialog;
    private EditText name, dateText, desc, amount;
    private String expenseOrIncome, date, category;
    private RadioGroup exOrInRadioGroup;
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Variables
        View v = inflater.inflate(R.layout.fragment_add, null);
        final AppCompatSpinner dropDown = v.findViewById(R.id.add_dropdown);
        Button add = v.findViewById(R.id.add_addButton);
        
        // Initializations
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        
        name = v.findViewById(R.id.add_nameText);
        desc = v.findViewById(R.id.add_descriptionText);
        amount = v.findViewById(R.id.add_amountText);
        dateText = v.findViewById(R.id.add_dateText);
        exOrInRadioGroup = v.findViewById(R.id.add_expense_purchase_radioGroup);
        
        // Create an ArrayAdapter using the string array and spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.starting_categories,
                android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        dropDown.setAdapter(adapter);

        // OnClick listener
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Determine if income or expense
                int selectedId = exOrInRadioGroup.getCheckedRadioButtonId();
    
                if (selectedId == R.id.add_income_radioButton)
                    expenseOrIncome = "Income";
                else
                    expenseOrIncome = "Expense";
    
                // Get the date
                date = dateText.getText().toString();
                
                // Check if valid date before adding expense
                if (date.length() == 10 && date.indexOf('/') == 2 && date.lastIndexOf('/') == 5) {    // Valid date
                    // Add expense to server
                    if(name.getText().toString().matches("")|desc.getText().toString().matches("")|
                               amount.getText().toString().matches("")){
                        Toast.makeText(getContext(), "One or more fields is/are empty", Toast.LENGTH_SHORT).show();
                    } else {
                        addExpense(name.getText().toString(), date, category, desc.getText().toString(), amount.getText().toString(), expenseOrIncome);
                    }
                }
                else    // Not a valid date
                {
                    Toast.makeText(getContext(), "Date format incorrect (MM/DD/YYYY)", Toast.LENGTH_SHORT).show();
                }
//                addIncome(name.toString(), category, desc.toString(), amount.toString());
            }
        });

        // OnItemSelected listener
        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                categoryId = id;
                category = dropDown.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        // Return
        return v;
    }
    
    /**
     * Private method that takes the Name, Category, Description, Amount, and the user's Token and sends a JSON Object Request to the server
     * to add the expense to the server
     *
     * @param name Name of the expense to be added to the server
     * @param category Category of the expense to be added to the server
     * @param description Description of the expense to be added to the server
     * @param amount Amount of the expense to be added to the server
     */
    private void addExpense(final String name, final String date, final String category, final String description , final String amount,
                            final String expenseOrIncome) {
        // Tag used to cancel the request
        String cancel_req_tag = "added";
        progressDialog.setMessage("Adding Income/Expense...");
        showDialog();
        
        Map<String, String> params = new HashMap<>();
//        params.put("expenseOrIncome", expenseOrIncome);
        params.put("expensesName", name);
//        params.put("date", date);
        params.put("category", category);
        params.put("description", description);
        params.put("amount", amount);
        params.put("token", AppSingleton.getInstance(getActivity()).getToken(getActivity(), "TOKEN"));
        
        JSONObject req = new JSONObject(params);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL_FOR_ADDING, req,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response){
                        try{
                            boolean error = response.getBoolean("error");
                            if(!error){
                                Toast.makeText(getActivity(), "Added income/expense successfully!", Toast.LENGTH_SHORT).show();
                                hideDialog();
                            } else {
                                Toast.makeText(getActivity(), response.getString("error_msg"), Toast.LENGTH_SHORT).show();
                                hideDialog();
                            }
                            
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(getActivity(), "An error occurred while adding, please try again.", Toast.LENGTH_LONG).show();
                error.printStackTrace();
                hideDialog();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError{
                Map<String, String> header = new HashMap<>();
                header.put("authorization", "Bearer "  + AppSingleton.getInstance(getContext()).getToken(getContext(),"TOKEN"));
                Log.d("THIS IS THE HEADER:", header.toString());
                return header;
            }
        };
        
        AppSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjectRequest, cancel_req_tag);
        System.out.println(jsonObjectRequest);
    }
    
    private void hideDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }
    private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }
    
}
