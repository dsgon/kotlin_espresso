package com.kotlin.espresso.views

import androidx.appcompat.app.AppCompatActivity
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.config.testData
import com.kotlin.espresso.steps.BaseSteps
import com.kotlin.espresso.steps.StepsSignUp
import org.junit.Rule
import org.junit.Test

class SignUpTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<SignUpActivity>(
        SignUpActivity::class.java

    )
    var stepsSignUp = StepsSignUp()

   ////////////////validate empty fields test cases/////////////////
    @Test
    fun validateEmptyFieldsErrorMessages(){
       stepsSignUp.clickSignUpButton()
       stepsSignUp.validateEmptyUserErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)
       stepsSignUp.setUser(testData.INPUTUSER)
       stepsSignUp.setEmail(testData.EMPTYVALUE)
       stepsSignUp.clickSignUpButton()
       stepsSignUp.validateEmptyEmailErrorMessage(activityRule as ActivityTestRule<AppCompatActivity> )
       stepsSignUp.setEmail(testData.INPUTEMAIL)
       stepsSignUp.setPassword(testData.EMPTYVALUE)
       stepsSignUp.clickSignUpButton()
       stepsSignUp.validateEmptyPasswordErrorMessage(activityRule as ActivityTestRule<AppCompatActivity> )
       stepsSignUp.setPassword(testData.INPUTPASS)
       stepsSignUp.clickSignUpButton()
       stepsSignUp.setPassword2(testData.EMPTYVALUE)
       stepsSignUp.clickSignUpButton()
       stepsSignUp.validateEmptyPassword2ErrorMessage(activityRule as ActivityTestRule<AppCompatActivity> )
//       stepsSignUp.setPassword2(testData.INPUTPASS2)
//       stepsSignUp.clickSignUpButton()
//       stepsSignUp.validateLogo()

   }
    @Test
    fun validateInvalidLoginErrorMessages(){
        stepsSignUp.setUser(testData.INVALIDINPUTUSER)
        stepsSignUp.clickSignUpButton()
        stepsSignUp.validateInvalidUserErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)
        stepsSignUp.setUser(testData.INPUTUSER)
        stepsSignUp.setEmail(testData.INVALIDINPUTEMAIL)
        stepsSignUp.clickSignUpButton()
        stepsSignUp.validateInvalidEmailErrorMessage(activityRule as ActivityTestRule<AppCompatActivity> )
        stepsSignUp.setEmail(testData.INPUTEMAIL)
        stepsSignUp.setPassword(testData.INVALIDINPUTPASS)
        stepsSignUp.clickSignUpButton()
        stepsSignUp.validateInvalidPasswordErrorMessage(activityRule as ActivityTestRule<AppCompatActivity> )
        stepsSignUp.setPassword(testData.INPUTPASS)
        stepsSignUp.setPassword2(testData.MISSMATCHINPUTPASS2)
        stepsSignUp.clickSignUpButton()
        stepsSignUp.validateMissmatchPasswordMessage(activityRule as ActivityTestRule<AppCompatActivity>)


    }


    @Test
    fun signUpSuccessfully(){
        var stepsSignUp = StepsSignUp()
        stepsSignUp.signUpForm(testData.INPUTUSER,testData.INPUTEMAIL,testData.INPUTPASS,testData.INPUTPASS2)
        stepsSignUp.clickSignUpButton()
        stepsSignUp.validateLogo()

    }

}