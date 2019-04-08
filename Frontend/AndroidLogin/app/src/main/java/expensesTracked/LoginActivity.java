package expensesTracked;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    //localhost testing
//    private static final String URL_FOR_LOGIN = "http://10.0.2.2:8080/demo/login";
    //server link
    private static final String URL_FOR_LOGIN = "http://cs309-yt-7.misc.iastate.edu:8080/demo/login";
    private EditText loginInputEmail, loginInputPassword;
    private ProgressDialog progressDialog;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        Button btnlogin, btnLinkSignup, btnBypass;
        
        loginInputEmail = findViewById(R.id.login_input_email);
        loginInputPassword = findViewById(R.id.login_input_password);
        
        btnlogin = findViewById(R.id.btn_login);
        btnLinkSignup = findViewById(R.id.btn_link_signup);
        btnBypass = findViewById(R.id.btn_bypass); // remove after login implementation working
        
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser(loginInputEmail.getText().toString(), loginInputPassword.getText().toString());
            }
        });
        btnLinkSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(goRegister);
            }
        });
        btnBypass.setOnClickListener(new View.OnClickListener() {   // TODO - remove after login implementation working
            @Override
            public void onClick(View view) {
                Intent goHome = new Intent(LoginActivity.this, UserActivity.class);
                startActivity(goHome);
            }
        });
        
    }

    /* Shub's Code
    private void loginUser(final String email, final String password) {
        String cancel_req_tag = "login";
        progressDialog.setMessage("Logging you in...");
        showDialog();
        StringRequest strReq = new StringRequest(Request.Method.POST, URL_FOR_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());
                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    if (!error) {
                        String user = jObj.getJSONObject("user").getString("name");
                        Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                        CurrentUser cUser = new CurrentUser();
                        cUser.setToken(user);
                        hideDialog();
                        startActivity(intent);
                        finish();
                    } else {
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(), errorMsg, Toast.LENGTH_LONG).show();
                        hideDialog();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", password);
                return params;
            }

        };


        // Adding request to request queue
        AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(strReq, cancel_req_tag);
    }*/
    
    private void loginUser(final String email, final String password){
        String cancel_req_tag = "login";
        progressDialog.setMessage("Logging you in...");
        showDialog();
        
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        
        JSONObject req = new JSONObject(params);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL_FOR_LOGIN, req, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response){
                try{
                    boolean error = response.getBoolean("error");
                    if(!error){
                        Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                        String token = response.getString("token");
                        saveToken(getApplicationContext(), "TOKEN", token);
                        hideDialog();
                        
                        startActivity(intent);
                        finish();
                    }
                    
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(getApplicationContext(), "Something is wrong", Toast.LENGTH_SHORT).show();
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
    
    private void saveToken(Context context, String key, String text) {
        android.content.SharedPreferences settings;
        android.content.SharedPreferences.Editor editor;
        
        settings = context.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.putString(key, text);
        editor.apply();
    }
    
    public String getToken(Context context, String key) {
        android.content.SharedPreferences settings;
        String text;
        settings = context.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
        text = settings.getString(key, null);
        
        return text;
    }
    
}
