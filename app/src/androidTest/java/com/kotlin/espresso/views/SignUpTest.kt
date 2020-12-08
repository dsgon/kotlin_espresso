package com.kotlin.espresso.views

import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.steps.StepsSignUp
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
        //steps.loginMessageValidation(activityRule)

    }

}