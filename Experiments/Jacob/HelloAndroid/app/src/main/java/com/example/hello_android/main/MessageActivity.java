package com.example.hello_android.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hello_android.R;

public class MessageActivity extends AppCompatActivity {

    private TextView smsMessage, smsPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Variables
        Button sendManager, sendIntent;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        sendManager = findViewById(R.id.smsManager);
        sendIntent = findViewById(R.id.smsSIntent);
        smsMessage = findViewById(R.id.smsBody);
        smsPhoneNumber = findViewById(R.id.phoneNumber);

        sendManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(smsPhoneNumber.getText().toString(), null, smsMessage.getText().toString(), null, null);
            }
        });

        sendIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendI = new Intent(Intent.ACTION_VIEW);
                sendI.putExtra(smsMessage.getText().toString(), smsPhoneNumber.getText().toString());
                sendI.setType("vnd.android-dir/mms-sms");
                startActivity(sendI);
            }
        });
    }

}
