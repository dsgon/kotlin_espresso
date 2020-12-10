package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.pages.PageCourse

class StepsCourse : BaseSteps() {

    private var pageCourse = PageCourse()

    fun validateImageIsDisplayed() : StepsCourse{
        Espresso.onView(pageCourse.getImageCourse()).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
        return this
    }

    fun validateTextIsDisplayed() : StepsCourse{
        Espresso.onView(pageCourse.getTextCourse()).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
        return this
    }

    fun validateCourseName(courseName : String) : StepsCourse{
        this.validateTextIsDisplayed()
        Espresso.onView(pageCourse.getTextCourse()).check(ViewAssertions.matches(
                ViewMatchers.withText(courseName)))
        return this
    }

}