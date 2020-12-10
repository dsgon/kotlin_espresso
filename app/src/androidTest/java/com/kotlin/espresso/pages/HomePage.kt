package com.kotlin.espresso.pages

import android.view.View
import com.kotlin.espresso.R
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class HomePage {

    private var homeImage = R.id.logo_wip
    private var coursesBtns = R.id.list_view


    fun getImgLogo(): Matcher<View>? {
        return ViewMatchers.withId(homeImage)
    }

    fun getCourses(): Matcher<View>? {
        return ViewMatchers.withId(coursesBtns)
    }



}