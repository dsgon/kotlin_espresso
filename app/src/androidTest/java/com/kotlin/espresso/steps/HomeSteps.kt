package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.pages.HomePage

class HomeSteps : BaseSteps() {

    private var homePage = HomePage()


    fun homePageValidation() {
        onView(homePage.getImgLogo())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(homePage.getImgLogo())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}