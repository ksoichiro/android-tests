package com.example.dockerhttpclient;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity
        implements ConnectTask.OnCompleteListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connect();
            }
        });
    }

    private void connect() {
        ConnectTask task = new ConnectTask();
        task.setOnCompleteListener(this);
        task.execute();
    }

    @Override
    public void onComplete(String result) {
        if (TextUtils.isEmpty(result)) {
            ((TextView) findViewById(R.id.text)).setText("Failed to access to server");
            return;
        }
        int number = parseResult(result);
        ((TextView) findViewById(R.id.text)).setText("Result: " + number);
    }

    private int parseResult(String result) {
        try {
            JSONObject json = new JSONObject(result);
            return json.getInt("result");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
