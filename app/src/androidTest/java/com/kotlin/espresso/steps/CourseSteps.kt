package com.kotlin.espresso.steps


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.pages.CoursesPage

class CourseSteps {

    private var coursesPage = CoursesPage()


    fun validateCoursePage() {
        onView(coursesPage.getCoursesTitle())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(coursesPage.getCoursesList())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


}