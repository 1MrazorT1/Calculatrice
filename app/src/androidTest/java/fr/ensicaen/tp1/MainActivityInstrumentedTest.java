package fr.ensicaen.tp1;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Before;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MainActivityInstrumentedTest {
    private ActivityScenario<MainActivity> scenario;

    @Before
    public void setup() {
        scenario = ActivityScenario.launch(MainActivity.class);
    }

    @Test
    public void testSetupElements() {
        scenario.onActivity(activity -> {
            assertNotNull(activity.findViewById(R.id.button0));
            assertNotNull(activity.findViewById(R.id.button1));
            assertNotNull(activity.findViewById(R.id.button2));
            assertNotNull(activity.findViewById(R.id.button3));
            assertNotNull(activity.findViewById(R.id.button4));
            assertNotNull(activity.findViewById(R.id.button5));
            assertNotNull(activity.findViewById(R.id.button6));
            assertNotNull(activity.findViewById(R.id.button7));
            assertNotNull(activity.findViewById(R.id.button8));
            assertNotNull(activity.findViewById(R.id.button9));
            assertNotNull(activity.findViewById(R.id.buttonPlus));
            assertNotNull(activity.findViewById(R.id.buttonMinus));
            assertNotNull(activity.findViewById(R.id.buttonTimes));
            assertNotNull(activity.findViewById(R.id.buttonSlash));
            assertNotNull(activity.findViewById(R.id.buttonEqual));
            assertNotNull(activity.findViewById(R.id.textView));
        });
    }

    @Test
    public void testNumberListeners() {
        onView(withId(R.id.button0)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("0")));

        onView(withId(R.id.buttonClear)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("")));

        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("1")));

        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("12")));
    }

    @Test
    public void testClearButton() {
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("1")));

        onView(withId(R.id.buttonClear)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("")));
    }

    @Test
    public void testOperators() {
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.buttonPlus)).perform(click());
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.buttonEqual)).perform(click());

        onView(withId(R.id.textView)).check(matches(withText("3")));
    }

    @Test
    public void testPointAndSignButtons() {
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.buttonPoint)).perform(click());
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("1.2")));

        onView(withId(R.id.buttonSign)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("-1.2")));
    }

    @Test
    public void testNotImplementedFunctions() {
        int[] buttonIds = new int[]{
                R.id.buttonSin, R.id.buttonCos, R.id.buttonTan, R.id.buttonLog, R.id.buttonLn,
                R.id.buttonSquare, R.id.buttonCube, R.id.buttonToTheFourth, R.id.buttonsqrt, R.id.buttonNiemeSqrt,
                R.id.buttonFactoriel, R.id.buttonAbs, R.id.buttonPi, R.id.buttonE, R.id.buttonCombinaison,
                R.id.buttonArrengement, R.id.buttonToDEG, R.id.buttonToRAD, R.id.buttonMod, R.id.button10ToTheX,
                R.id.buttonExp
        };

        for (int id : buttonIds) {
            onView(withId(id)).perform(click());
            onView(withId(R.id.textView)).check(matches(withText("NOT IMPLEMENTED YET...")));
        }
    }

    @Test
    public void testRemoveButton() {
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.buttonRemove)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("1")));
    }

    @Test
    public void testMultipleOperations() {
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.buttonTimes)).perform(click());
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.buttonEqual)).perform(click());

        onView(withId(R.id.textView)).check(matches(withText("6")));
    }

    @Test
    public void testSetupListeners() {
        scenario.onActivity(activity -> {
            Button button = activity.findViewById(R.id.button0);
            assertNotNull(button);
            button.performClick();
            TextView textView = activity.findViewById(R.id.textView);
            assertTrue(textView.getText().toString().contains("0"));
        });
    }
}
