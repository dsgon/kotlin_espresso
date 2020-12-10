package com.kotlin.espresso.views

import androidx.appcompat.app.AppCompatActivity
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.steps.SignUpSteps
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
        var steps =SignUpSteps()
        steps.setUser("DavidSGH")
        steps.validateLoginErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)

    }

}