package fr.ensicaen.tp1;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import java.io.IOException;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testValidAddition() {
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.buttonPlus)).perform(click());
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.buttonEqual)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("5.0")));
    }

    @Test
    public void testClearButton() {
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.buttonClear)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("")));
    }

    @Test
    public void testRemoveButton() {
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.buttonRemove)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("1")));
    }

    @Test
    public void testInvalidExpression() {
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.buttonPlus)).perform(click());
        onView(withId(R.id.buttonEqual)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("Error")));
    }

    @Test
    public void testDivisionByZero() {
        onView(withId(R.id.button9)).perform(click());
        onView(withId(R.id.buttonSlash)).perform(click());
        onView(withId(R.id.button0)).perform(click());
        onView(withId(R.id.buttonEqual)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("Error")));
    }
}
