package com.kotlin.espresso.test.viewPOM

import androidx.appcompat.app.AppCompatActivity
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.facade.FacadeSignUp
import com.kotlin.espresso.steps.StepsHome
import com.kotlin.espresso.steps.StepsSignUp
import com.kotlin.espresso.views.SignUpActivity
import org.junit.Rule
import org.junit.Test

/**
 * Validaciones completa de Formulario de Registro
 */
class SignUpTestPOM {

    @Rule @JvmField
    var activityRule = ActivityTestRule<SignUpActivity>(
        SignUpActivity::class.java
    )

    @Test
    fun testSignUpSuccessfully(){
        FacadeSignUp().doRegister("user Name", "userName@test.com", "12345678", "12345678")
        StepsHome().validateLogoIsDisplayed()
                .validateTextIsDisplayed()
                .validateCoursesButtonIsDisplayed()

    }

    @Test
    fun testEmptyForm(){
        FacadeSignUp().doRegister("", "", "", "")
        StepsSignUp().validateUserNameEmptyErrorMessage()
                .validateGeneralErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

    @Test
    fun testUserNameEmpty(){
        FacadeSignUp().doRegister("", "userName@test.com", "12345678", "12345678")
        StepsSignUp().validateUserNameEmptyErrorMessage()
                .validateGeneralErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

    @Test
    fun testUserNameSpecialChars(){
        FacadeSignUp().doRegister("user N@me$", "userName@test.com", "12345678", "12345678")
        StepsSignUp().validateUserNameSpecialCharsErrorMessage()
                .validateGeneralErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

    @Test
    fun testEmailEmpty(){
        FacadeSignUp().doRegister("user name", "", "12345678", "12345678")
        StepsSignUp().validateEmailEmptyErrorMessage()
                .validateGeneralErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

    @Test
    fun testEmailInvalid(){
        FacadeSignUp().doRegister("user name", "username@test", "12345678", "12345678")
        StepsSignUp().validateEmailInvalidErrorMessage()
                .validateGeneralErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

    @Test
    fun testPasswordEmpty(){
        FacadeSignUp().doRegister("user name", "username@test.com", "", "12345678")
        StepsSignUp().validatePasswordEmptyErrorMessage()
                .validateGeneralErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

    @Test
    fun testPasswordLength(){
        FacadeSignUp().doRegister("user name", "username@test.com", "1234567", "12345678")
        StepsSignUp().validatePasswordLengthErrorMessage()
                .validateGeneralErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

    @Test
    fun testConfirmPasswordEmpty(){
        FacadeSignUp().doRegister("user name", "username@test.com", "12345678", "")
        StepsSignUp().validateConfirmPasswordEmptyErrorMessage()
                .validateGeneralErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

    @Test
    fun testConfirmPasswordMismatch(){
        FacadeSignUp().doRegister("user name", "username@test.com", "12345678", "12345687")
        StepsSignUp().validateConfirmPasswordMismatchErrorMessage()
                .validateGeneralErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

}