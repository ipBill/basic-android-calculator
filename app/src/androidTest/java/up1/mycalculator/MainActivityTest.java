package up1.mycalculator;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);


    @Test
    public void first_test_case() {

        //Arrange
        onView(withId(R.id.firstNumber)).perform(typeText("5"));
        onView(withId(R.id.secondNumber)).perform(typeText("4"));

        //Act
        onView(withId(R.id.calculateButton)).perform(click());

        //Assert
        onView(withId(R.id.result)).check(matches(withText("9")));

    }


}

