package com.example.hello_android.net_utils;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.example.hello_android.R;
import com.example.hello_android.app.AppController;
import com.example.hello_android.net_utils.StringRequest;

public class StringRequest extends AppCompatActivity {
    // Variables
    private String tag_string_req = "json_obj_req";

    private String url = "https://api.androidhive.info/volley/person_object.json";

    private ProgressDialog pDialog = new ProgressDialog(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Variables
        Button stringRequest;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_request);

        stringRequest = findViewById(R.id.buttonStringRequest);

        pDialog.setMessage("Loading...");

//        stringRequest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pDialog.show();
//
//                StringRequest strReq = new StringRequest(Method.GET, url, new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Log.d(AppController.TAG, response.toString());
//                        pDialog.hide();
//                    }
//                }, new Response.ErrorListener() {
//
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        VolleyLog.d(TAG, "Error: " + error.getMessage());
//                        pDialog.hide();
//                    }
//                });
//
//                // Adding request to request queue
//                AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
//            }
//        });


    }

}
