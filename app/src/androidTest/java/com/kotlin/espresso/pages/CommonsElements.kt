package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import org.hamcrest.Matcher

class CommonsElements {

    var menu = R.id.action_bar

    fun getMenu(): Matcher<View>{
        return ViewMatchers.withId(menu)
    }
}