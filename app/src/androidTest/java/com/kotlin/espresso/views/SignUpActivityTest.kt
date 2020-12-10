package com.kotlin.espresso.views

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.R
import com.kotlin.espresso.core.helper.ErrorMessage
import kotlinx.android.synthetic.main.activity_sign_up.view.*
import org.hamcrest.CoreMatchers
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
    fun validateFieldsAreDisplayed(){
        Espresso.onView(ViewMatchers.withId(R.id.input_user)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_email)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_password)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_password2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_sign_up)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
    }

    @Test
    fun createNewValidUser(){
        Espresso.onView(ViewMatchers.withId(R.id.input_user)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("TestTest"))
        Espresso.onView(ViewMatchers.withId(R.id.input_email)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("test@test.com"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.input_password)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("password"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.input_password2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("password"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.btn_sign_up)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.logo_wip)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    @Test
    fun verifyInvalidSignUpNoData(){
        Espresso.onView(ViewMatchers.withId(R.id.input_user)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_email)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_password)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_password2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_sign_up)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText(ErrorMessage.GENERAL_ERROR)).
        inRoot(RootMatchers.withDecorView(CoreMatchers.not(CoreMatchers.`is`(activityRule.activity.window.decorView)))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    @Test
    fun verifyInvalidUsernameSignUp(){
        Espresso.onView(ViewMatchers.withId(R.id.input_user)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("Test$$"))
        Espresso.onView(ViewMatchers.withId(R.id.input_email)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("test@test.com"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.input_password)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("password"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.input_password2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("password"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.btn_sign_up)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText(ErrorMessage.GENERAL_ERROR)).
        inRoot(RootMatchers.withDecorView(CoreMatchers.not(CoreMatchers.`is`(activityRule.activity.window.decorView)))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_user)).check(ViewAssertions.matches(ViewMatchers.hasErrorText(ErrorMessage.USERNAME_SPECIAL_CHARS_ERROR)))

    }

    @Test
    fun validateNoMatchingPasswords(){
        Espresso.onView(ViewMatchers.withId(R.id.input_user)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("TestTest"))
        Espresso.onView(ViewMatchers.withId(R.id.input_email)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("test@test.com"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.input_password)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("password"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.input_password2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("password2"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.btn_sign_up)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText(ErrorMessage.GENERAL_ERROR)).
        inRoot(RootMatchers.withDecorView(CoreMatchers.not(CoreMatchers.`is`(activityRule.activity.window.decorView)))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_password2)).check(ViewAssertions.matches(ViewMatchers.hasErrorText(ErrorMessage.REPEAT_PASS_DOESNT_MATCH_ERROR)))
    }

    @Test
    fun validateInvalidEmailFormat(){
        Espresso.onView(ViewMatchers.withId(R.id.input_user)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("TestTest"))
        Espresso.onView(ViewMatchers.withId(R.id.input_email)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("testcom"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.input_password)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("password"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.input_password2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("password"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.btn_sign_up)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText(ErrorMessage.GENERAL_ERROR)).
        inRoot(RootMatchers.withDecorView(CoreMatchers.not(CoreMatchers.`is`(activityRule.activity.window.decorView)))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_email)).check(ViewAssertions.matches(ViewMatchers.hasErrorText(ErrorMessage.EMAIL_INVALID_ERROR)))
    }

    @Test
    fun emptyPasswordValidation(){
        Espresso.onView(ViewMatchers.withId(R.id.input_user)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("TestTest"))
        Espresso.onView(ViewMatchers.withId(R.id.input_email)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("test@com.co"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.input_password2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("password"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.btn_sign_up)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText(ErrorMessage.GENERAL_ERROR)).
        inRoot(RootMatchers.withDecorView(CoreMatchers.not(CoreMatchers.`is`(activityRule.activity.window.decorView)))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_password)).check(ViewAssertions.matches(ViewMatchers.hasErrorText(ErrorMessage.PASS_EMPTY_ERROR)))
    }

    @Test
    fun lengthPasswordValidation(){
        Espresso.onView(ViewMatchers.withId(R.id.input_user)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("TestTest"))
        Espresso.onView(ViewMatchers.withId(R.id.input_email)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("test@com.co"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.input_password2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.typeText("12"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.btn_sign_up)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText(ErrorMessage.GENERAL_ERROR)).
        inRoot(RootMatchers.withDecorView(CoreMatchers.not(CoreMatchers.`is`(activityRule.activity.window.decorView)))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_password)).check(ViewAssertions.matches(ViewMatchers.hasErrorText(ErrorMessage.PASS_LENGTH_ERROR)))
    }


}