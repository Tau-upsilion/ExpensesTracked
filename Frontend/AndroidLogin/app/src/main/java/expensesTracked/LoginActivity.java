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

/**
 * Login Activity class
 */
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
//    localhost testing;
    private static final String URL_FOR_LOGIN = "http://10.0.2.2:8080/demo/login";
    //server link
   // private static final String URL_FOR_LOGIN = "http://cs309-yt-7.misc.iastate.edu:8080/demo/login";
    private EditText loginInputEmail, loginInputPassword;
    private ProgressDialog progressDialog;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        Button btnlogin, btnLinkSignup, btnBypass;  // TODO - delete bypass when login full functional
        
        loginInputEmail = findViewById(R.id.login_input_email);
        loginInputPassword = findViewById(R.id.login_input_password);
        
        btnlogin = findViewById(R.id.btn_login);
        btnLinkSignup = findViewById(R.id.btn_link_signup);
        btnBypass = findViewById(R.id.btn_bypass);  // TODO - delete
        
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
        btnBypass.setOnClickListener(new View.OnClickListener() {   // TODO - delete
            @Override
            public void onClick(View view) {
                Intent goRegister = new Intent(LoginActivity.this, UserActivity.class);
                startActivity(goRegister);
            }
        });
        
    }
    
    /**
     * Private method to login a user using a JSON Object Request
     *
     * @param email - Email entered by the user to be checked with the different user emails located on the server
     * @param password - Password entered by the user to be checked with the  located on the server
     */
    private void loginUser(final String email, final String password){
        String cancel_req_tag = "login";
        progressDialog.setMessage("Logging you in...");
        showDialog();
        
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        
        JSONObject req = new JSONObject(params);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL_FOR_LOGIN, req,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response){
                    try{
                        boolean error = response.getBoolean("error");
                        if(!error){
                            Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                            String token = response.getString("token");
                            saveToken(getApplicationContext(), token);
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
                    Toast.makeText(getApplicationContext(), "An error occurred while logging in, please try again.", Toast.LENGTH_LONG).show();
                    error.printStackTrace();
                    hideDialog();
                }
        });
        
        AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest, cancel_req_tag);
    }
    
    /**
     * Private method to show the progress dialog
     */
    private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }
    
    /**
     * Private method to hide the progress dialog
     */
    private void hideDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }
    
    /**
     * Helper method to save the token created by the server and returned from the JSON Object Request
     *
     * @param context - Application context
     * @param text - The token
     */
    private void saveToken(Context context, String text) {
        android.content.SharedPreferences settings;
        android.content.SharedPreferences.Editor editor;
        
        settings = context.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.putString("TOKEN", text);
        editor.apply();
    }
    
}
