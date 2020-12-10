package com.kotlin.espresso.pages

import android.view.View
import com.kotlin.espresso.R
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class PageHome {

    private var image = R.id.logo_wip
    private var btnCourses = R.id.list_view


    fun imgLogo(): Matcher<View>? {
        return ViewMatchers.withId(image)
    }

    fun btnCourses(): Matcher<View>? {
        return ViewMatchers.withId(btnCourses)
    }



}