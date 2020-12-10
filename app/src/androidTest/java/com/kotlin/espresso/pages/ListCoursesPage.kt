package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.hamcrest.core.AllOf.allOf

class ListCoursesPage {
    fun getOption(option : String) : Matcher<View>? {

        return withText(option)

    }
}