package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import org.hamcrest.Matcher

class ListCoursesPage {


    var title = R.id.title_courses
    var listCourses = R.id.title_courses

    fun labelTitle(): Matcher<View>? {
        return ViewMatchers.withId(title)
    }

    fun listCourses(): Matcher<View>? {
        return ViewMatchers.withId(listCourses)
    }


}