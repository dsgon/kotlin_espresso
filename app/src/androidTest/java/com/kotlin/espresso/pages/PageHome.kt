package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import org.hamcrest.Matcher

class PageHome {

    private var logo = R.id.logo_wip
    private var textWip = R.id.text_wip
    private var coursesButton = R.id.list_view

    fun getLogo(): Matcher<View>? {
        return  ViewMatchers.withId(logo)
    }

    fun getText(): Matcher<View>? {
        return  ViewMatchers.withId(textWip)
    }

    fun getCoursesButton(): Matcher<View>? {
        return  ViewMatchers.withId(coursesButton)
    }

}