package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class PageList {

    fun getOption(option : String) : Matcher<View>? {
        return ViewMatchers.withText(option)
    }
}