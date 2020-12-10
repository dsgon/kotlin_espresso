package com.kotlin.espresso.views

import androidx.appcompat.app.AppCompatActivity
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.steps.HomeSteps
import com.kotlin.espresso.steps.LoginSteps
import org.junit.Rule
import org.junit.Test


class LoginTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<LoginActivity>(
            LoginActivity::class.java
    )

    @Test
    fun verifyLoginActivity(){
        var steps = LoginSteps()

        steps.verifyLogoWip()
        steps.verifyInputEmail()
        steps.verifyInputPassword()
        steps.verifyLoginButton()
        steps.verifyLinkRegister()
    }

    @Test
    fun validLoginUser(){
        var steps = LoginSteps()
        var stepsHome = HomeSteps()

        steps.setEmail ("emailvalid@gmail.com")
        steps.setPassword ("12345678")
        steps.closeKeyboard()
        steps.clickLoginButton()
        stepsHome.verifyHomePage()
    }

    @Test
    fun EmptyPassword(){
        var steps = LoginSteps()

        steps.setEmail ("test@gmail.com")
        steps.setPassword ("")
        steps.closeKeyboard()
        steps.clickLoginButton()
        steps.validateEmptyPasswordErrorMessage()
       }

    @Test
    fun InvalidPassword(){
        var steps = LoginSteps()

        steps.setEmail ("test@gmail.com")
        steps.setPassword ("12")
        steps.closeKeyboard()
        steps.clickLoginButton()
        steps.validateInputPasswordErrorMessage()
    }

    @Test
    fun EmptyEmail(){
        var steps = LoginSteps()

        steps.setEmail ("")
        steps.setPassword ("12345678")
        steps.closeKeyboard()
        steps.clickLoginButton()
        steps.validateEmptyEmailErrorMessage()
    }

    @Test
    fun InvalidEmail(){
        var steps = LoginSteps()

        steps.setEmail ("tes")
        steps.setPassword ("12345678")
        steps.closeKeyboard()
        steps.clickLoginButton()
        steps.validateInputEmailErrorMessage()
    }

    @Test
    fun LoginError(){
        var steps = LoginSteps()

        steps.setEmail ("test@gmail.com")
        steps.setPassword ("12")
        steps.closeKeyboard()
        steps.clickLoginButton()
        steps.validateErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)
    }


}
