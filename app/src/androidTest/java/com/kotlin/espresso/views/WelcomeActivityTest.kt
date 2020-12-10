package com.kotlin.espresso.views

import LoginActivityTest
import android.view.View
import android.widget.ImageButton
import android.widget.Toolbar
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.R
import com.kotlin.espresso.steps.WelcomeActivitySteps
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import java.util.regex.Matcher


class WelcomeActivityTest {

    @Rule @JvmField
    var activityRule = ActivityTestRule<WelcomeActivity>(
            WelcomeActivity::class.java
    )


    @Test
    fun test3(){
        println("Scenario 3")
        Espresso.onView(ViewMatchers.withId(R.id.icon_wip)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        WelcomeActivitySteps().waitWelcomePageLoad()
        Espresso.onView(ViewMatchers.withId(R.id.link_register)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        SignUpActivityTest().createNewValidUser()
      //  Espresso.onView(navigationIconMatcher())
        Espresso.onView(ViewMatchers.withContentDescription("More Options")).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.list_view)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
    }

    @Test
    fun test4(){
        println("Scenario 4")
        Espresso.onView(ViewMatchers.withId(R.id.icon_wip)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        WelcomeActivitySteps().waitWelcomePageLoad()
        LoginActivityTest().validLogin()

    }

}