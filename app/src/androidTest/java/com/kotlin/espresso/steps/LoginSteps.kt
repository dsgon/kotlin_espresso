package com.kotlin.espresso.steps

import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.R
import com.kotlin.espresso.core.helper.ErrorMessage
import com.kotlin.espresso.pages.ErrorMessages
import com.kotlin.espresso.pages.LoginPage


class LoginSteps : BaseSteps() {

    var page = LoginPage()

    fun setEmail(email : String){
        Espresso.onView(
                page.getInputEmail()
        ).perform(ViewActions.typeText(email))
    }

    fun setPassword(pwd : String){
        Espresso.onView(
                page.getInputPassword()
        ).perform(ViewActions.typeText(pwd))
    }

    fun clickLoginButton(){
        Espresso.onView(
                page.getButtonLogin()
        ).perform(ViewActions.click())
    }

    fun clickSingUpLink(){
        Espresso.onView(
                page.getLinkRegister()
        ).perform(ViewActions.click())
    }

    fun verifyInputEmail(){
        Espresso.onView((page.getInputEmail())).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
    }

    fun verifyInputPassword(){
        Espresso.onView((page.getInputPassword())).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
    }
    fun verifyLoginPage(){
        verifyLogoWip()
        verifyLoginButton()
        verifyLinkRegister()
    }

    fun verifyLogoWip(){
        Espresso.onView((page.getLogoWip())).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
    }

    fun verifyLoginButton(){
        Espresso.onView((page.getButtonLogin())).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
    }

    fun verifyLinkRegister(){
        Espresso.onView((page.getLinkRegister())).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
    }

    fun validateErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>){
        validateToastMessage(activityRule, ErrorMessages().getLoginError())
    }

    fun validateInputEmailErrorMessage(){
        Espresso.onView((page.getInputEmail())).check(ViewAssertions.matches(
                hasErrorText(ErrorMessage.EMAIL_INVALID_ERROR)))
    }


    fun validateEmptyEmailErrorMessage(){
        Espresso.onView((page.getInputEmail())).check(ViewAssertions.matches(
                hasErrorText(ErrorMessage.EMAIL_EMPTY_ERROR)))
    }

    fun validateEmptyPasswordErrorMessage(){
        Espresso.onView((page.getInputPassword())).check(ViewAssertions.matches(
                hasErrorText(ErrorMessage.PASS_EMPTY_ERROR)))
    }

    fun validateInputPasswordErrorMessage(){
        Espresso.onView((page.getInputPassword())).check(ViewAssertions.matches(
                hasErrorText(ErrorMessage.PASS_LENGTH_ERROR)))
    }

}