package com.kotlin.espresso.test.viewPOM

import androidx.appcompat.app.AppCompatActivity
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.facade.FacadeLogin
import com.kotlin.espresso.steps.StepsHome
import com.kotlin.espresso.steps.StepsLogin
import com.kotlin.espresso.views.LoginActivity
import org.junit.Rule
import org.junit.Test

/**
 * Validaciones completa de formulario de Login
 */
class LoginTestPOM {

    @Rule @JvmField
    var activityRule = ActivityTestRule<LoginActivity>(
            LoginActivity::class.java
    )

    @Test
    fun testSignUpSuccessfully(){
        FacadeLogin().doLogin("userName@test.com", "12345678")
        StepsHome().validateLogoIsDisplayed()
                .validateTextIsDisplayed()
                .validateCoursesButtonIsDisplayed()

    }

    @Test
    fun testEmptyForm(){
        FacadeLogin().doLogin("", "")
        StepsLogin().validateEmailEmptyErrorMessage()
                .validateLoginErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

    @Test
    fun testEmailEmpty(){
        FacadeLogin().doLogin("", "12345678")
        StepsLogin().validateEmailEmptyErrorMessage()
                .validateLoginErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

    @Test
    fun testEmailInvalid(){
        FacadeLogin().doLogin("userName@.com", "12345678")
        StepsLogin().validateEmailInvalidErrorMessage()
                .validateLoginErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

    @Test
    fun testPasswordEmpty(){
        FacadeLogin().doLogin("userName@test.com", "")
        StepsLogin().validatePasswordEmptyErrorMessage()
                .validateLoginErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

    @Test
    fun testPasswordLength(){
        FacadeLogin().doLogin("userName@test.com", "1234567")
        StepsLogin().validatePasswordLengthErrorMessage()
                .validateLoginErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

}