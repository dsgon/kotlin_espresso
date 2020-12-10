package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import com.kotlin.espresso.core.data.GenerateData
import com.kotlin.espresso.pages.ListCoursesPage
import org.hamcrest.Matchers
import org.hamcrest.core.AllOf.allOf




class ListCoursesSteps : BaseSteps(){

    var page = ListCoursesPage()

    fun selectCourse(option : String) {
        Espresso.onView(allOf(page.getOption(option)))
            .perform(ViewActions.scrollTo())
            .perform(ViewActions.scrollTo())
            .perform(ViewActions.click())
    }
    fun validateCoursesInfo(){
        Espresso.onView(ViewMatchers.withId(R.id.list_courses)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()))

    }

    fun openCourse(index:Int) {
        var courseName = GenerateData().generateData().get(index).name
        ListCoursesSteps().selectCourse(courseName)
        Espresso.onView(ViewMatchers.withId(R.id.main_title_course)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(courseName)
            )
        )


    }

}