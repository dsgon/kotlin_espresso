package com.kotlin.espresso.pages

import android.view.View
import com.kotlin.espresso.R
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class PageListCourses {


    var title = R.id.title_courses
    var listCourses = R.id.list_courses

    fun labelTitle(): Matcher<View>? {
        return ViewMatchers.withId(title)
    }

    fun listCourses(): Matcher<View>? {
        return ViewMatchers.withId(listCourses)
    }



}