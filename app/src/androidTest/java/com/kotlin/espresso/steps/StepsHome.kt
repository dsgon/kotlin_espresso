package com.kotlin.espresso.steps

import android.os.SystemClock.sleep
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.pages.ErrorMessages
import com.kotlin.espresso.pages.PageHome
import com.kotlin.espresso.views.LoginActivity
import org.hamcrest.Matchers.allOf

class StepsHome : BaseSteps() {

    private var homePage = PageHome()


    // To verify all elements of the page "email@domain.com" "Password"
    fun loginPageVisible(emailTxt: String, passwordTxt: String) {
        onView(homePage.imgLogo())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(homePage.btnCourses())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }



    fun tapCourses() {
        onView(homePage.btnCourses())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
    }



}