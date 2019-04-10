package expensesTracked;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.toolbox.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    // Instance Variables
    private static final String TAG = "RegisterActivity";
    //localhost testing (comment out if demoing)
//    private static final String URL_FOR_REGISTRATION = "http://10.0.2.2:8080/demo/register";
    //server Implementation comment (uncomment if demo)
    private static final String URL_FOR_REGISTRATION = "http://cs309-yt-7.misc.iastate.edu:8080/demo/register";
    private EditText signupInputName, signupInputEmail, signupInputPassword, signupInputAge;
    private RadioGroup genderRadioGroup;
    private boolean isValidLogin = false;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Variables
        Button btnSignUp, btnLinkLogin;

        // Progress dialog initialization
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        // Edit text initialization
        signupInputName = (EditText) findViewById(R.id.signup_input_name);
        signupInputEmail = (EditText) findViewById(R.id.signup_input_email);
        signupInputPassword = (EditText) findViewById(R.id.signup_input_password);
        signupInputAge = (EditText) findViewById(R.id.signup_input_age);

        // Radio group initialization
        genderRadioGroup = (RadioGroup) findViewById(R.id.gender_radio_group);

        // Button initialization
        btnSignUp = (Button) findViewById(R.id.btn_signup);
        btnLinkLogin = (Button) findViewById(R.id.btn_link_login);

        // Button OnClick Listeners
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check for valid email and password on signup
                isValidLogin = checkCredentials(signupInputEmail.getText().toString(), signupInputPassword.getText().toString());

                // Try register
                if (isValidLogin)
                    submitForm();
            }
        });
        btnLinkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });
    }

    public boolean checkCredentials(String email, String password) {
        // Declare variables
        boolean isValidEmail, isValidPassword;

        // Check for valid email
        isValidEmail = email.length() >= 8 && email.contains("@") && email.contains(".") && (email.indexOf("@") < email.indexOf('.'));
        // Check for valid password
        isValidPassword = password.length() >= 8;

        // Display invalid input messages
        if (!isValidEmail && isValidPassword)
        {
            // Invalid email
            Toast.makeText(getApplicationContext(), "Invalid email. Try again", Toast.LENGTH_LONG).show();
            return false;
        }
        else if (isValidEmail && !isValidPassword)
        {
            // Invalid password
            Toast.makeText(getApplicationContext(), "Invalid password. Try again", Toast.LENGTH_LONG).show();
            return false;
        }
        else if (!isValidEmail) // only have to check if email validity because of else ifs
        {
            // Invalid email and password
            Toast.makeText(getApplicationContext(), "Invalid email and password. Try again", Toast.LENGTH_LONG).show();
            return false;
        }
        else
        {
            // All valid credentials
            return true;
        }

    }

    private void submitForm() {
        int selectedId = genderRadioGroup.getCheckedRadioButtonId();
        String gender;

        if (selectedId == R.id.female_radio_btn)
            gender = "Female";
        else
            gender = "Male";

        registerUser(signupInputName.getText().toString(), signupInputEmail.getText().toString(), signupInputPassword.getText().toString(),
                gender, signupInputAge.getText().toString());
    }

    private void registerUser(final String name, final String email, final String password, final String gender, final String dob) {
        // Tag used to cancel the request
        String cancel_req_tag = "register";

        progressDialog.setMessage("Adding you...");
        showDialog();
    
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", name);
        params.put("email", email);
        params.put("password", password);
        params.put("gender", gender);
        params.put("age", dob);
        
        JSONObject req = new JSONObject(params);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL_FOR_REGISTRATION, req,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            boolean error = response.getBoolean("error");
                            if (!error) {
                                String user = response.getString("name");
                                Toast.makeText(getApplicationContext(), "Hi " + user + ", You are successfully Added!", Toast.LENGTH_SHORT).show();
                                hideDialog();
                                
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                String error_MSG = response.getString("error_msg");
                                Toast.makeText(getApplicationContext(), error_MSG, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                error.printStackTrace();
                hideDialog();
            }
        });
        
        AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest, cancel_req_tag);
    }
    
    private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }
    
    private void hideDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

}
