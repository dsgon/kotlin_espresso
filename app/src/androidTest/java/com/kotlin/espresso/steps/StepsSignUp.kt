package com.kotlin.espresso.steps


import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.action.ViewActions
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.pages.ErrorMessages
import com.kotlin.espresso.pages.PageSignUp
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers

class StepsSignUp : BaseSteps() {

    var pageSignUp = PageSignUp()

    fun setUser(name: String, email: String, password: String, conPassowrd: String) {
        onView(pageSignUp.getInputEmail())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(name))
        onView(pageSignUp.getInputPassword())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(email))
        onView(pageSignUp.getInputPassConfirmation())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(conPassowrd))
        closeKeyboard()
        onView(pageSignUp.clickRegister())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
    }

    fun validateLoginErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>){
        validateToastMessage(activityRule,ErrorMessages().getLoginError())
    }
}