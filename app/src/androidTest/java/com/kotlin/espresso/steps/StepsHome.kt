package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.pages.PageHome

class StepsHome  : BaseSteps()  {

    private var pageHome = PageHome()

    fun validateTextIsDisplayed() : StepsHome{
        Espresso.onView(pageHome.getText())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun validateLogoIsDisplayed() : StepsHome{
        Espresso.onView(pageHome.getLogo())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun validateCoursesButtonIsDisplayed() : StepsHome{
        Espresso.onView(pageHome.getCoursesButton())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun clickCourses(){
        validateCoursesButtonIsDisplayed()
        Espresso.onView(pageHome.getCoursesButton()).perform(ViewActions.click())
    }

}