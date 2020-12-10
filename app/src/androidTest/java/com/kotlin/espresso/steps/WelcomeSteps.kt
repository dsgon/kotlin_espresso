package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.pages.WelcomePage

class WelcomeSteps {
    var page = WelcomePage()

    fun validateWelcomeLogoIsDisplayed(){
        Espresso.onView(page.getWelcomeLogo())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    fun clickSignUpButton(){
        Espresso.onView(page.getSignUpButton())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(page.getSignUpButton())
            .perform(ViewActions.click())
    }
}