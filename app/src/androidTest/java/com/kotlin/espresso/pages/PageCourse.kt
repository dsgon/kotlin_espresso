package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import org.hamcrest.Matcher

class PageCourse {

    private var imageCourse = R.id.main_image_course
    private var textCourse = R.id.main_title_course

    fun getImageCourse() : Matcher<View>? {
        return ViewMatchers.withId(imageCourse)
    }

    fun getTextCourse() : Matcher<View>? {
        return ViewMatchers.withId(textCourse)
    }
}