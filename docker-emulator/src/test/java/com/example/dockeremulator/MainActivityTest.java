package com.example.dockeremulator;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private TextView text;
    private Button button;

    @SuppressWarnings("deprecation")
    public MainActivityTest() {
        super("com.example.dockeremulator", MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        text = (TextView) getActivity().findViewById(R.id.text);
        button = (Button) getActivity().findViewById(R.id.button);
    }

    public void testOnClick() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.performClick();
            }
        });

        getInstrumentation().waitForIdleSync();

        // To confirm the test is working, set invalid condition.
        // This test must fail.
        assertEquals("NO!", text.getText());
    }
}
