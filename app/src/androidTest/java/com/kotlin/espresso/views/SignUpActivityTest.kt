package com.kotlin.espresso.views

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.R
import kotlinx.android.synthetic.main.activity_sign_up.view.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SignUpActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<SignUpActivity>(
        SignUpActivity::class.java
    )

    @Test
    fun verifyInputUser(){
        Espresso.onView(ViewMatchers.withId(R.id.input_user)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_email)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_password)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_password2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}