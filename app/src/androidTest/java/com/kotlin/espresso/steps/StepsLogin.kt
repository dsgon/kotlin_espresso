package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.pages.ErrorMessages
import com.kotlin.espresso.pages.PageLogin
import com.kotlin.espresso.views.LoginActivity

class StepsLogin : BaseSteps() {

    var loginPage = PageLogin()

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

    // To verify all elements of the page
    fun loginPageVisible() {
        onView(loginPage.imgLogo())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(loginPage.labelTitle())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(loginPage.labelEmail())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(loginPage.getInputEmail())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(loginPage.getInputPasword())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(loginPage.getInputPasword())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(loginPage.btnLogin())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(loginPage.btnSingUp())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

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

}