package com.ruth.spellinggame;

import android.content.Intent;

import com.ruth.spellinggame.ui.GameFragment;
import com.ruth.spellinggame.ui.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.junit.Before;

import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup(){
        activity = Robolectric.setupActivity(MainActivity.class);
    }
    @Test
    public void secondActivityStarted(){
        activity.findViewById(R.id.button).performClick();
        Intent expectedIntent = new Intent(activity, GameFragment.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
