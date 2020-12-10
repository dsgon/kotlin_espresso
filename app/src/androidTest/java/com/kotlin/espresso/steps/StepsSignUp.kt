package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.pages.ErrorMessages
import com.kotlin.espresso.pages.PageSignUp
import com.kotlin.espresso.views.LoginActivity
import com.kotlin.espresso.views.SignUpActivity

class StepsSignUp : BaseSteps() {

    var singUpPage = PageSignUp()

    // To verify all elements of the page
    fun singUpPageVisible() {
        onView(singUpPage.imgLogo())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(singUpPage.labelTitle())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(singUpPage.labelUserName())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(singUpPage.labelUserEmail())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(singUpPage.labelUserPassword())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(singUpPage.getInputUser())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).check(
                ViewAssertions.matches(
                    ViewMatchers.withHint("Username")
                )
            )
        onView(singUpPage.getInputEmail())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).check(
                ViewAssertions.matches(
                    ViewMatchers.withHint("email@domain.com")
                )
            )
        onView(singUpPage.getInputPasword())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).check(
                ViewAssertions.matches(
                    ViewMatchers.withHint("Password")
                )
            )
        onView(singUpPage.getInputRepeatPasword())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).check(
                ViewAssertions.matches(
                    ViewMatchers.withHint("Repeat Password")
                )
            )
        onView(singUpPage.clickRegister())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(singUpPage.clickLinkLogin())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    fun setUser(name: String, email: String, password: String, conPassowrd: String) {
        onView(singUpPage.getInputUser())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(name))
        onView(singUpPage.getInputEmail())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(email))
        onView(singUpPage.getInputPasword())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(password))
        onView(singUpPage.getInputRepeatPasword())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(conPassowrd))
        closeKeyboard()
        onView(singUpPage.clickRegister())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
    }

    // To verify error messages of login page
    fun singUpMessageValidation(activityRule: ActivityTestRule<LoginActivity>) {
        onView(singUpPage.clickRegister())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        validateToastMessage(activityRule, ErrorMessages().getGeneralError())

    }


}