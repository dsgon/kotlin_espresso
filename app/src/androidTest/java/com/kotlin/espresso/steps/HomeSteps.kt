package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.pages.HomePage

class HomeSteps {
    var page = HomePage()
    fun validateHomeLogo(){
        Espresso.onView(page.getHomeLogo()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    fun clickCoursesButton(){
        Espresso.onView(page.getcoursesLink()).perform(ViewActions.click())
    }
}