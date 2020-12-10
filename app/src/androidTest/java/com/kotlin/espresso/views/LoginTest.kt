package com.kotlin.espresso.views

import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.steps.StepsLogin
import org.junit.Rule
import org.junit.Test

class LoginTest {

    // 2.- Validaciones completa de formulario de Login

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<LoginActivity>(
        LoginActivity::class.java
    )

    @Test
    fun loginVisible() {
        val steps = StepsLogin()
        steps.loginPageVisible("email@domain.com", "Password")
    }

    @Test
    fun loginMessagesValidation() {
        val steps = StepsLogin()
        steps.loginMessageValidation(activityRule)
    }

    @Test
    fun loginSucces() {
        val steps = StepsLogin()
        steps.loginUser("test@test.com", "12345678")
    }

    @Test
    fun loginEmptyField() {
        val steps = StepsLogin()
        steps.loginEmptyFields(
            "The field Email cannot be empty", "The field Password cannot be empty",
            "The Email is not valid", "The Password must be contain 8 characters"
        )
    }




}