package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import org.hamcrest.Matcher

class PageWelcome {
    private var icon = R.id.icon_wip

    fun getIcon() : Matcher<View>? {
        return  ViewMatchers.withId(icon)
    }

}