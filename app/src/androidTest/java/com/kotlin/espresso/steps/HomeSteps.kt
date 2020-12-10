package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.pages.HomePage
import com.kotlin.espresso.views.MenuOptions


class HomeSteps  : BaseSteps() {

    var page = HomePage()

    fun verifyHomePage(){
        Espresso.onView((page.getTextWip())).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
        Espresso.onView((page.getCoursesButton())).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
    }


    fun clickCoursesButton(){
        Espresso.onView(
                page.getCoursesButton()
        ).perform(ViewActions.click())
    }


}