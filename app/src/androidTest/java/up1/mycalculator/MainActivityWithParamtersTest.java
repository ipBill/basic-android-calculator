package up1.mycalculator;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(Parameterized.class)
public class MainActivityWithParamtersTest {

    private final String mFirst;
    private final String mSecond;
    private final String mOperator;
    private final String mResult;
    @Rule
    public ActivityTestRule<MainActivity> mMainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Parameterized.Parameters
    public static Iterable<Object[]> setupData() {
        return Arrays.asList(
                new Object[][]{
                        {"5", "4", "+", "9"},
                        {"5", "1", "+", "6"}
                }
        );
    }

    public MainActivityWithParamtersTest(String first, String second,
                                         String operator, String result) {
        mFirst = first;
        mSecond = second;
        mOperator = operator;
        mResult = result;
    }

    @Test
    public void first_test_case() {

        //Arrange
        onView(withId(R.id.firstNumber)).perform(typeText(this.mFirst));
        onView(withId(R.id.secondNumber)).perform(typeText(this.mSecond));

        //Act
        onView(withId(R.id.calculateButton)).perform(click());

        //Assert
        onView(withId(R.id.result)).check(matches(withText(this.mResult)));

    }


}