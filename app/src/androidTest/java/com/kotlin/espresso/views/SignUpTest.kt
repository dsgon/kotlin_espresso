package com.kotlin.espresso.views

import androidx.appcompat.app.AppCompatActivity
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.steps.HomeSteps
import com.kotlin.espresso.steps.LoginSteps
import com.kotlin.espresso.steps.SignUpSteps
import com.kotlin.espresso.steps.StepsSignUp
import org.junit.Rule
import org.junit.Test

open class SignUpTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<SignUpActivity>(
        SignUpActivity::class.java
    )


    @Test
    fun verifySignupActivity(){
        var steps = SignUpSteps()

        steps.verifyInputUser()
        steps.verifyInputEmail()
        steps.verifyInputPassword()
        steps.verifyInputConfirm()
        steps.verifyBtnSignUp()
        steps.verifylinkLogin()
    }


    @Test
    fun signUpUser(){
        var steps = SignUpSteps()
        var stepsHome = HomeSteps()

        steps.setUser("luiscouto")
        steps.setEmail ("test@gmail.com")
        steps.setPassword("12345678")
        steps.closeKeyboard()
        steps.setConfirm("12345678")
        steps.closeKeyboard()
        steps.clickBtnSignUp()
        stepsHome.verifyHomePage()

    }

    @Test
    fun differentPassword(){
        var steps = SignUpSteps()

        steps.setUser("test")
        steps.setEmail ("test@gmail.com")
        steps.setPassword ("12345678")
        steps.closeKeyboard()
        steps.setConfirm ("12345679")
        steps.closeKeyboard()
        steps.clickBtnSignUp()
        steps.validateDifferentPasswordErrorMessage()
    }

    @Test
    fun invalidLengthPassword(){
        var steps = SignUpSteps()

        steps.setUser("test")
        steps.setEmail ("test@gmail.com")
        steps.setPassword ("123456")
        steps.closeKeyboard()
        steps.setConfirm ("123456")
        steps.closeKeyboard()
        steps.clickBtnSignUp()
        steps.validateInvalidLengthPasswordErrorMessage()
    }

    @Test
    fun invalidEmail(){
        var steps = SignUpSteps()

        steps.setUser("test")
        steps.setEmail ("test")
        steps.setPassword ("12345678")
        steps.closeKeyboard()
        steps.setConfirm ("12345678")
        steps.closeKeyboard()
        steps.clickBtnSignUp()
        steps.validateInvalidEmailErrorMessage()
    }

    @Test
    fun emptyUser(){
        var steps = SignUpSteps()

        steps.setUser("")
        steps.setEmail ("test")
        steps.setPassword ("12345678")
        steps.closeKeyboard()
        steps.setConfirm ("12345678")
        steps.closeKeyboard()
        steps.clickBtnSignUp()
        steps.validateEmptyUserErrorMessage()
    }

    @Test
    fun emptyEmail(){
        var steps = SignUpSteps()

        steps.setUser("test")
        steps.setEmail ("")
        steps.setPassword ("12345678")
        steps.closeKeyboard()
        steps.setConfirm ("12345678")
        steps.closeKeyboard()
        steps.clickBtnSignUp()
        steps.validateEmptyEmailErrorMessage()
    }

    @Test
    fun emptyPassword(){
        var steps = SignUpSteps()

        steps.setUser("test")
        steps.setEmail ("test@gmail.com")
        steps.setPassword ("")
        steps.closeKeyboard()
        steps.setConfirm ("")
        steps.closeKeyboard()
        steps.clickBtnSignUp()
        steps.validateEmptyPasswordErrorMessage()
    }

    @Test
    fun emptyConfirmPassword(){
        var steps = SignUpSteps()

        steps.setUser("test")
        steps.setEmail ("test@gmail.com")
        steps.setPassword ("12345678")
        steps.closeKeyboard()
        steps.setConfirm ("")
        steps.closeKeyboard()
        steps.clickBtnSignUp()
        steps.validateEmptyConfirmPasswordErrorMessage()
    }

    @Test
    fun generalError(){
        var steps = SignUpSteps()

        steps.setUser("test")
        steps.setEmail ("test@gmail.com")
        steps.setPassword ("12345678")
        steps.closeKeyboard()
        steps.setConfirm ("")
        steps.closeKeyboard()
        steps.clickBtnSignUp()
        steps.validateErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)
    }



}