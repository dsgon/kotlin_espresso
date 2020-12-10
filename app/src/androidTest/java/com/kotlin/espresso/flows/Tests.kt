package com.kotlin.espresso.flows

import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.steps.*
import com.kotlin.espresso.views.WelcomeActivity
import org.junit.Rule
import org.junit.Test

class Tests {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<WelcomeActivity>(
        WelcomeActivity::class.java
    )

    @Test
    fun TestCaseFirst() {

        LoginSteps().validateLoginPage()
        StepsSignUp().setUser("Franscisco", "test@email.com", "pass123", "pass123")

    }


}