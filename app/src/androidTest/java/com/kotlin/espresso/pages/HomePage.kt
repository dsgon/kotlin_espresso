package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import org.hamcrest.Matcher

class HomePage  : CommonsElements()  {

    var textWip = R.id.text_wip

    fun getTextWip(): Matcher<View>? {
        return  ViewMatchers.withId(textWip)
    }

    var coursesButton = R.id.list_view

    fun getCoursesButton(): Matcher<View>? {
        return  ViewMatchers.withId(coursesButton)
    }
}