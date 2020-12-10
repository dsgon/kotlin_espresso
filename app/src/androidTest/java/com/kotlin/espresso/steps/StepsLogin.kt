package com.kotlin.espresso.steps

import android.os.SystemClock.sleep
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.pages.ErrorMessages
import com.kotlin.espresso.pages.PageLogin
import com.kotlin.espresso.views.LoginActivity
import org.hamcrest.Matchers.allOf

class StepsLogin : BaseSteps() {

    private var loginPage = PageLogin()

    // basic Login
    fun loginUser(user: String, passowrd: String) {
        onView(loginPage.getInputEmail())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(user))
        onView(loginPage.getInputPasword())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(passowrd))
        closeKeyboard()
        onView(loginPage.btnLogin())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
    }

    // To verify all elements of the page "email@domain.com" "Password"
    fun loginPageVisible(emailTxt: String, passwordTxt: String) {
        onView(loginPage.imgLogo())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(loginPage.labelTitle())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(loginPage.labelEmail())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(loginPage.getInputEmail())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .check(matches(withHint(emailTxt)))
        onView(loginPage.getInputPasword())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .check(matches(withHint(passwordTxt)))
        onView(loginPage.getInputPasword())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(loginPage.btnLogin())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(loginPage.btnSingUp())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    // To verify error messages of login page
    fun loginMessageValidation(activityRule: ActivityTestRule<LoginActivity>) {
        onView(loginPage.getInputEmail())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(" "))
        closeKeyboard()
        onView(loginPage.btnLogin())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        validateToastMessage(activityRule, ErrorMessages().getLoginError())
        onView(loginPage.getInputPasword())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText("1"))
        validateToastMessage(activityRule, ErrorMessages().getLoginError())
    }

    // To verify error messages of login page empty fields
    fun loginEmptyFields(
        message: String,
        messageTwo: String,
        messageTree: String,
        messageFour: String
    ) {
        onView(loginPage.btnLogin())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        onView(allOf(withText(message)))
        onView(loginPage.getInputEmail())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText("test@user"))
        onView(loginPage.btnLogin())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        onView(allOf(withText(messageTwo)))
        onView(loginPage.getInputEmail())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText("test@user.com"))
        onView(loginPage.btnLogin())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        onView(allOf(withText(messageTree)))
        sleep(2000)
        onView(loginPage.getInputPasword())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText("12"))
        onView(loginPage.btnLogin())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        onView(allOf(withText(messageFour)))
    }




    fun tapSingUp() {
        onView(loginPage.btnSingUp())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
    }



}