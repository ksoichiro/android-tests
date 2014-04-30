package com.example.example;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.example.robolectric.RobolectricGradleTestRunner;

import static org.junit.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {

    @Test
    public void shouldPass() {
        assertTrue(true);
    }

    @Test
    public void shouldFail() {
        assertTrue(false);
    }

}
