package com.kotlin.espresso.steps

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.core.helper.ErrorMessage
import com.kotlin.espresso.pages.ErrorMessages
import com.kotlin.espresso.pages.PageSignUp

class StepsSignUp : BaseSteps() {

    var page = PageSignUp()

    fun setUser(user: String){
        Espresso.onView(page.getInputUser()).perform(ViewActions.replaceText(user))
       // Espresso.onView(page.getInputUser()).perform(ViewActions.typeText(user))
        closeKeyboard()
    }

    fun setEmail( email : String){
        Espresso.onView(page.getinputEmail()).perform(ViewActions.doubleClick())
        //Espresso.onView(page.getinputEmail()).perform(ViewActions.typeText(email))
        Espresso.onView(page.getinputEmail()).perform(ViewActions.replaceText(email))
        closeKeyboard()
    }
    fun setPassword(password : String){

        Espresso.onView(page.getinputPassword()).perform(ViewActions.doubleClick())
        Espresso.onView(page.getinputPassword()).perform(ViewActions.replaceText(password))
       // closeKeyboard()
    }
    fun setPassword2(password2: String){
        Espresso.onView(page.getInputUser()).perform(ViewActions.doubleClick())
        Espresso.onView(page.getinputPassword2()).perform(ViewActions.doubleClick())
        Espresso.onView(page.getinputPassword2()).perform(ViewActions.replaceText(password2))
        closeKeyboard()

    }
    fun clickSignUpButton(){
        Espresso.onView(page.getsignUpButton()).perform(ViewActions.click())
    }
    fun validateLogo(){
        Espresso.onView(page.getappLogo()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun signUpForm(user: String, email: String, password: String, password2 : String){
        setUser(user)
        setEmail(email)
        setPassword(password)
        setPassword2(password2)
        //clickSignUpButton()

    }
    fun validateEmptyUserErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>){
        validateToastMessage(activityRule, ErrorMessages().getEmptyUserError())
    }
    fun validateEmptyEmailErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>){
        validateToastMessage(activityRule, ErrorMessages().getEmptyEmailError())
    }
    fun validateEmptyPasswordErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>){
        validateToastMessage(activityRule, ErrorMessages().getEmptyPasswordError())
    }
    fun validateEmptyPassword2ErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>){
        validateToastMessage(activityRule, ErrorMessages().getEmptyRepeatPasswordError())
    }
    fun validateInvalidUserErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>){
        validateToastMessage(activityRule, ErrorMessages().getInvalidUserError())
    }
    fun validateInvalidEmailErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>){
        validateToastMessage(activityRule, ErrorMessages().getInvalidEmailError())
    }
    fun validateInvalidPasswordErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>){
        validateToastMessage(activityRule, ErrorMessages().getInvalidPasswordError())
    }
    fun validateInvlidPassword2ErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>){
        validateToastMessage(activityRule, ErrorMessages().getPasswordMissmatchError())
    }

    fun validateLoginErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>){
        validateToastMessage(activityRule, ErrorMessages().getLoginError())
    }
   fun validateMissmatchPasswordMessage(activityRule : ActivityTestRule<AppCompatActivity>){
       validateToastMessage(activityRule, ErrorMessages().getPasswordMissmatchError())
   }



}