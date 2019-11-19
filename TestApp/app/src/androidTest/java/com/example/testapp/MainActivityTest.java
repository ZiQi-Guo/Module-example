package com.example.testapp;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * @author guozq
 * @date 2019/6/29 0029下午 15:14
 * @desc MainActivity测试类
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void main() {
        onView(
                //allOf(
                withId(R.id.text_view)
                //, withText("Hello World!"))
        ).check(matches(withText("Hello World!"))).perform(click());

        onView(withId(R.id.text_view));
    }
}
