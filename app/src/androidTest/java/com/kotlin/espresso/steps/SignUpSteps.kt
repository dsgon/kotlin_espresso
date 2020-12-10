package com.kotlin.espresso.steps

import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.core.helper.ErrorMessage
import com.kotlin.espresso.pages.ErrorMessages
import com.kotlin.espresso.pages.LoginPage
import com.kotlin.espresso.pages.SignUpPage

class SignUpSteps : BaseSteps() {


    var page = SignUpPage()

    fun setUser(user : String){
        Espresso.onView(
                page.getInputUser()
        ).perform(ViewActions.typeText(user))
    }

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

    fun setConfirm(confirm : String){
        Espresso.onView(
                page.getinputConfirm()
        ).perform(ViewActions.typeText(confirm))
    }

    fun clickBtnSignUp(){
        Espresso.onView(
                page.getbtnSignUp()
        ).perform(ViewActions.click())
    }

    fun verifyInputUser(){
        Espresso.onView((page.getInputUser())).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
    }

    fun verifyInputEmail(){
        Espresso.onView((page.getInputEmail())).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
    }

    fun verifyInputPassword(){
        Espresso.onView((page.getInputPassword())).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
    }

    fun verifyInputConfirm(){
        Espresso.onView((page.getinputConfirm())).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
    }

    fun verifyBtnSignUp(){
        Espresso.onView((page.getbtnSignUp())).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
    }


    fun verifylinkLogin(){
        Espresso.onView((page.getlinkLogin())).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
    }

    fun validateDifferentPasswordErrorMessage(){
        Espresso.onView((page.getinputConfirm())).check(ViewAssertions.matches(
                ViewMatchers.hasErrorText(ErrorMessage.REPEAT_PASS_DOESNT_MATCH_ERROR)))
    }

    fun validateInvalidLengthPasswordErrorMessage(){
        Espresso.onView((page.getInputPassword())).check(ViewAssertions.matches(
                ViewMatchers.hasErrorText(ErrorMessage.PASS_LENGTH_ERROR)))
    }

    fun validateInvalidEmailErrorMessage(){
        Espresso.onView((page.getInputEmail())).check(ViewAssertions.matches(
                ViewMatchers.hasErrorText(ErrorMessage.EMAIL_INVALID_ERROR)))
    }
    fun validateEmptyUserErrorMessage(){
        Espresso.onView((page.getInputUser())).check(ViewAssertions.matches(
                ViewMatchers.hasErrorText(ErrorMessage.USERNAME_EMPTY_ERROR)))
    }

    fun validateEmptyEmailErrorMessage(){
        Espresso.onView((page.getInputEmail())).check(ViewAssertions.matches(
                ViewMatchers.hasErrorText(ErrorMessage.EMAIL_EMPTY_ERROR)))
    }

    fun validateEmptyPasswordErrorMessage(){
        Espresso.onView((page.getInputPassword())).check(ViewAssertions.matches(
                ViewMatchers.hasErrorText(ErrorMessage.PASS_EMPTY_ERROR)))
    }

    fun validateEmptyConfirmPasswordErrorMessage(){
        Espresso.onView((page.getinputConfirm())).check(ViewAssertions.matches(
                ViewMatchers.hasErrorText(ErrorMessage.REPEAT_PASS_EMPTY_ERROR)))
    }
    fun validateErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>){
        validateToastMessage(activityRule, ErrorMessages().getGeneralError())
    }

    }