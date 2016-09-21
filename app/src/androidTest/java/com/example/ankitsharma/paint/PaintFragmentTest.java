package com.example.ankitsharma.paint;

import android.content.Context;
import android.graphics.Color;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.intent.IntentMonitorRegistry;
import android.test.ServiceTestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Method;

import timber.log.Timber;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.assertEquals;

/**
 * Created by ankitsharma on 9/21/16.
 */

@RunWith(AndroidJUnit4.class)
public class PaintFragmentTest {

    private Context context;

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

//    @Test
//    public void testPalleteClick() {
//        sleepForOneSecond();
//        onView(withId(R.id.pallete_icon))
//                .perform(click())
//                .check(matches(isDisplayed()));
//    }
//
//    @Test
//    public void testBrushClick() {
//        sleepForOneSecond();
//        onView(withId(R.id.brush_icon))
//                .perform(click())
//                .check(matches(isDisplayed()));
//    }

    @Before
    public void setup() {
        context = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void testBothPalleteBrushClick() {
        sleepForOneSecond();
        onView(withId(R.id.pallete_icon))
                .perform(click())
                .check(matches(isDisplayed()));
        onView(withId(R.id.brush_icon))
                .perform(click())
                .check(matches(isDisplayed()));
    }

    @Test
    public void testPalleteColorsVisible() {
        sleepForOneSecond();
        onView(withId(R.id.pallete_icon))
                .perform(click());

        onView(withId(R.id.black_button))
                .check(matches(isDisplayed()));
        onView(withId(R.id.blue_button))
                .check(matches(isDisplayed()));
        onView(withId(R.id.red_button))
                .check(matches(isDisplayed()));
        onView(withId(R.id.yellow_button))
                .check(matches(isDisplayed()));
        onView(withId(R.id.magenta_button))
                .check(matches(isDisplayed()));
        onView(withId(R.id.green_button))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testBrushWidthsVisible() {
        sleepForOneSecond();

        onView(withId(R.id.brush_icon))
                .perform(click());

        onView(withId(R.id.brush_24))
                .check(matches(isDisplayed()));
        onView(withId(R.id.brush_18))
                .check(matches(isDisplayed()));
        onView(withId(R.id.brush_12))
                .check(matches(isDisplayed()));
        onView(withId(R.id.brush_6))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testColorSharedPreference() {
        sleepForOneSecond();

        onView(withId(R.id.pallete_icon))
                .perform(click());
        sleepForOneSecond();
        onView(withId(R.id.blue_button))
                .perform(click());
        assertEquals(Color.BLUE, Utility.getBrushColorPref(context));
    }

    @Test
    public void testBrushWidthPreference() {
        int BRUSH12_WIDTH = 10;
        sleepForOneSecond();
        onView(withId(R.id.brush_icon))
                .perform(click());
        sleepForOneSecond();
        onView(withId(R.id.brush_12))
                .perform(click());

        assertEquals(BRUSH12_WIDTH, Utility.getBrushWidthPref(context));
    }

    private void sleepForOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Timber.e(e);
        }
    }
}
