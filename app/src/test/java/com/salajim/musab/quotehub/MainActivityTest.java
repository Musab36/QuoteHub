package com.salajim.musab.quotehub;


import android.content.Intent;
import android.os.Build;

import com.salajim.musab.quotehub.ui.MainActivity;
import com.salajim.musab.quotehub.ui.QuoteListActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertTrue;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    // A test for checking if Quote activity starts correctly
    @Test
    public void secondActivityStarted() {
        activity.findViewById(R.id.btn).performClick();
        Intent expectedIntent = new Intent(activity, QuoteListActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
