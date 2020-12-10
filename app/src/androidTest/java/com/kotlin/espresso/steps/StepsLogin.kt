package com.kotlin.espresso.steps

import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.core.helper.ErrorMessage
import com.kotlin.espresso.pages.ErrorMessages
import com.kotlin.espresso.pages.PageLogin

class StepsLogin : BaseSteps() {

    var pageLogin = PageLogin()

    fun validateEmailIsDisplayed() : StepsLogin{
        Espresso.onView(pageLogin.getInputEmail())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun validatePasswordIsDisplayed() : StepsLogin{
        Espresso.onView(pageLogin.getInputPassword())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun validateLoginButtonIsDisplayed() : StepsLogin{
        Espresso.onView(pageLogin.getLoginButton())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun validateRegisterLinkIsDisplayed() : StepsLogin{
        Espresso.onView(pageLogin.getRegisterLink())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun setEmail(email : String) : StepsLogin {
        this.validateEmailIsDisplayed()
        Espresso.onView(pageLogin.getInputEmail()).perform(ViewActions.typeText(email), ViewActions.pressImeActionButton())
        return this
    }

    fun setPassword(password : String) : StepsLogin {
        this.validatePasswordIsDisplayed()
        Espresso.onView(pageLogin.getInputPassword()).perform(ViewActions.typeText(password), ViewActions.pressImeActionButton())
        return this
    }

    fun clickLoginButton(){
        this.validateLoginButtonIsDisplayed()
        Espresso.onView(pageLogin.getLoginButton()).perform(ViewActions.click())
    }

    fun clickRegisterLink(){
        this.validateRegisterLinkIsDisplayed()
        Espresso.onView(pageLogin.getRegisterLink()).perform(ViewActions.click())
    }

    fun validateLoginErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>) : StepsLogin {
        validateToastMessage(activityRule, ErrorMessages().getLoginError())
        return this
    }

    fun validateEmailEmptyErrorMessage() : StepsLogin {
        validateErrorOnField(pageLogin.getInputEmail(), ErrorMessage.EMAIL_EMPTY_ERROR)
        return this
    }

    fun validateEmailInvalidErrorMessage() : StepsLogin {
        validateErrorOnField(pageLogin.getInputEmail(), ErrorMessage.EMAIL_INVALID_ERROR)
        return this
    }

    fun validatePasswordEmptyErrorMessage() : StepsLogin {
        validateErrorOnField(pageLogin.getInputPassword(), ErrorMessage.PASS_EMPTY_ERROR)
        return this
    }

    fun validatePasswordLengthErrorMessage() : StepsLogin {
        validateErrorOnField(pageLogin.getInputPassword(), ErrorMessage.PASS_LENGTH_ERROR)
        return this
    }
}