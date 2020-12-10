package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import org.hamcrest.Matcher

class PagePreferences {

    private var checkboxProgrammer  = R.id.checkbox_programmer
    private var checkboxQA = R.id.checkbox_qa
    private var checkboxAutomation = R.id.checkbox_automation

    fun getCheckboxProgrammer() : Matcher<View>? {
        return  ViewMatchers.withId(checkboxProgrammer)
    }

    fun getCheckboxQA() : Matcher<View>? {
        return  ViewMatchers.withId(checkboxQA)
    }

    fun getCheckboxAutomation() : Matcher<View>? {
        return  ViewMatchers.withId(checkboxAutomation)
    }
}