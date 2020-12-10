package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import com.kotlin.espresso.pages.LoginPage

class LoginSteps {
    var page = LoginPage()

    fun enterEmail(email:String){
        Espresso.onView(ViewMatchers.withId(R.id.input_email)).check(
            ViewAssertions.matches(
            ViewMatchers.isDisplayed())).perform(ViewActions.typeText(email))
    }
    fun enterPassword(password:String){
        Espresso.onView(ViewMatchers.withId(R.id.input_password)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed())).perform(ViewActions.typeText(password))
    }
    fun clickLoginButton(){
        Espresso.onView(ViewMatchers.withId(R.id.btn_login)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed())).perform(ViewActions.click())
    }
    fun login(email: String, password: String){
        enterEmail(email)
        enterPassword(password)
        clickLoginButton()
    }

    }