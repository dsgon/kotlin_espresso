package com.kotlin.espresso.pages

import android.view.View
import com.kotlin.espresso.R
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class PagePreference {


    private var title = R.id.title
    private var chkProgramer = R.id.checkbox_programmer
    private var chkQa = R.id.checkbox_qa
    private var chkAutomation = R.id.checkbox_automation

    fun title(): Matcher<View>? {
        return ViewMatchers.withId(title)
    }

    fun chkProgramer(): Matcher<View>? {
        return ViewMatchers.withId(chkProgramer)
    }

    fun chkQa(): Matcher<View>? {
        return ViewMatchers.withId(chkQa)
    }

    fun chkAutomation(): Matcher<View>? {
        return ViewMatchers.withId(chkAutomation)
    }

}