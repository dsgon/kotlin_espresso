package com.kotlin.espresso.views

import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.pages.PageSignUp
import com.kotlin.espresso.steps.StepsSignUp
import org.junit.Rule
import org.junit.Test

class SignUpTest {

    // 1.- Validaciones completa de Formulario de Registro

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<SignUpActivity>(
        SignUpActivity::class.java
    )

    @Test
    fun signUpUser() {
        var steps = StepsSignUp()
        steps.setUser("Pedro", "test@email.com", "12345678", "12345678")
        //steps.loginMessageValidation(activityRule)

    }

    @Test
    fun singUpPageVisible() {
        var steps = StepsSignUp()
        steps.singUpPageVisible()
    }


}