package com.kotlin.espresso.test.views

import androidx.appcompat.app.AppCompatActivity
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.steps.StepsSignUp
import com.kotlin.espresso.views.SignUpActivity
import org.junit.Rule
import org.junit.Test

class SignUpTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<SignUpActivity>(
        SignUpActivity::class.java
    )

    @Test
    fun signUpUser(){
        var steps =StepsSignUp()
        steps.setUser("DavidSGH")
        steps.validateLoginErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

}