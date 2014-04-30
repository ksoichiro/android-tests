package com.example.dockerhttpclient;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private TextView text;
    private Button button;

    @SuppressWarnings("deprecation")
    public MainActivityTest() {
        super("com.example.dockerhttpclient", MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        text = (TextView) getActivity().findViewById(R.id.text);
        button = (Button) getActivity().findViewById(R.id.button);
    }

    public void testOnClickConnect() throws InterruptedException {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.performClick();
            }
        });

        getInstrumentation().waitForIdleSync();
        Thread.sleep(ConnectTask.CONNECT_TIMEOUT);

        int number = 1;
        if (BuildConfig.FLAVOR.equals("integration")) {
            number = 0;
        }
        assertEquals("Result: " + number, text.getText());
    }
}
