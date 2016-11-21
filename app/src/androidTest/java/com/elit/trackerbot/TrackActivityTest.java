package com.elit.trackerbot;


import android.support.annotation.NonNull;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TrackActivityTest {

    @Rule
    public ActivityTestRule<TrackActivity_> mActivityTestRule = new ActivityTestRule<>(TrackActivity_.class);

    @Test
    public void whenTrackingProjectShowsTrackingInfo() {
        assertTrackingInfo("You still didn't track today :D");
        clickTrackButton();
        assertTrackingInfo("You tracked Project XXX");
    }

    @NonNull
    private ViewInteraction assertTrackingInfo(String b) {
        return onView(withText(b)).check(matches(isDisplayed()));
    }

    @NonNull
    private ViewInteraction clickTrackButton() {
        return onView(withId(R.id.trackButton)).perform(click());
    }

}
