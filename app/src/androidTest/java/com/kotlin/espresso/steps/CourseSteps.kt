package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import com.kotlin.espresso.pages.CoursePage
import org.hamcrest.CoreMatchers


class CourseSteps : BaseSteps() {

    var page = CoursePage()

   private fun openCourseInfo(indexCourse: Int){

        Espresso.onData(CoreMatchers.anything()).inAdapterView(ViewMatchers.withId(R.id.list_courses))
                .atPosition(indexCourse).perform(ViewActions.click())
    }

    fun verifyCourseInfo(){

        Espresso.onView(ViewMatchers.withId(R.id.main_title_course)).check(
                ViewAssertions.matches(
                        ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.main_image_course)).check(
                ViewAssertions.matches(
                        ViewMatchers.isDisplayed()))
    }

    fun verifyListCoursesPage(){
        Espresso.onView(ViewMatchers.withId(R.id.list_courses)).check(
                ViewAssertions.matches(
                        ViewMatchers.isDisplayed()))

     }

    fun selectGitCourse (){
    openCourseInfo(5)
    }

    fun selectJUnitCourse (){
        openCourseInfo(3)
    }

}