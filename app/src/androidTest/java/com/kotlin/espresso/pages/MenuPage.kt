package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import kotlinx.android.synthetic.main.activity_preference.view.*
import org.hamcrest.Matcher

class MenuPage {
    var qaOption = R.id.checkbox_qa
    var programmerOption = R.id.checkbox_programmer
    var automationOption = R.id.checkbox_automation

    fun getQAOption(): Matcher<View>? {
        return  ViewMatchers.withId(qaOption)
    }
    fun getProgrammerOption(): Matcher<View>? {
        return  ViewMatchers.withId(programmerOption)
    }
    fun getAutomationOption(): Matcher<View>? {
        return  ViewMatchers.withId(automationOption)
    }

}