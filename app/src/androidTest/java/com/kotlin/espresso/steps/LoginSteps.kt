package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.pages.LoginPage

class LoginSteps : BaseSteps() {

    var pageLogin = LoginPage()

    fun validateLoginPage()  {
        onView(pageLogin.getLoginImg())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(pageLogin.getLoginTitle())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(pageLogin.getEmailInput())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(pageLogin.getPasswordInput())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(pageLogin.getLoginBtn())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(pageLogin.getSignUpLink())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    fun inputEmail(email : String) : LoginSteps {
        Espresso.onView(pageLogin.getEmailInput()).perform(ViewActions.typeText(email), ViewActions.pressImeActionButton())
        return this
    }

    fun inputPassword(password : String) : LoginSteps {
        Espresso.onView(pageLogin.getPasswordInput()).perform(ViewActions.typeText(password), ViewActions.pressImeActionButton())
        return this
    }



}