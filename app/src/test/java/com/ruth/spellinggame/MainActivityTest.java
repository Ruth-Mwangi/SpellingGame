package com.ruth.spellinggame;

import com.ruth.spellinggame.ui.MainActivity;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.junit.Before;

import org.robolectric.Robolectric;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup(){
        activity = Robolectric.setupActivity(MainActivity.class);
    }
}
