package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.pages.ErrorMessages
import com.kotlin.espresso.pages.PageSignUp
import com.kotlin.espresso.views.SignUpActivity

class StepsSignUp : BaseSteps() {

    var page = PageSignUp()

    fun setUser(user: String) {
        Espresso.onView(page.getInputUser())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText("name"))
        Espresso.onView(page.getInputEmail())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText("email"))
        Espresso.onView(page.getInputPasword())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText("Password"))
        Espresso.onView(page.getInputRepeatPasword())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText("password"))
        Espresso.onView(page.clickRegister())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
    }

}