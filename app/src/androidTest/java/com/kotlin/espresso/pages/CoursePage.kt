package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import org.hamcrest.Matcher

class CoursePage {

    var titleCourse = R.id.main_title_course

    var imageCourse = R.id.main_image_course

    fun getImageCourse(): Matcher<View>? {
        return  ViewMatchers.withId(imageCourse)
    }

    fun getTitleCourse(): Matcher<View>? {
        return  ViewMatchers.withId(titleCourse)
    }
}