package com.salajim.musab.quotehub;


import android.support.test.rule.ActivityTestRule;

import com.salajim.musab.quotehub.ui.QuoteListActivity;

import org.junit.Rule;

public class QuoteActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<QuoteListActivity> activityTestRule = new ActivityTestRule<>(QuoteListActivity.class);

    // A test for checking if Toasts work perfect
    /*
    @Test
    public void quotetsClickedDisplayToastWithCorrectQuote() {
        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
        onData(anything())
                .inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());
    }
    */
}
