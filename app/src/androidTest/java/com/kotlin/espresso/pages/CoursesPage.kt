package com.kotlin.espresso.pages

import android.view.View
import com.kotlin.espresso.R
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class CoursesPage {


    var coursesTitle = R.id.title_courses
    var coursesList = R.id.list_courses

    fun getCoursesTitle(): Matcher<View>? {
        return ViewMatchers.withId(coursesTitle)
    }

    fun getCoursesList(): Matcher<View>? {
        return ViewMatchers.withId(coursesList)
    }


}