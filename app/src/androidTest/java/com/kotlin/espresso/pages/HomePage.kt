package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import kotlinx.android.synthetic.main.activity_home.view.*
import org.hamcrest.Matcher

class HomePage {
    var homeLogo = R.id.logo_wip
    var coursesLink = R.id.list_view

    fun getHomeLogo(): Matcher<View>? {
        return  ViewMatchers.withId(homeLogo)
    }
    fun getcoursesLink(): Matcher<View>? {
        return  ViewMatchers.withId(coursesLink)
    }
}