package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import org.hamcrest.Matcher

class PreferencesPage  : CommonsElements() {

    var checkpProgrammer = R.id.checkbox_programmer
    var checkpQa = R.id.checkbox_qa
    var checkAutomation = R.id.checkbox_automation

    fun getcheckProgrammer(): Matcher<View>? {
        return  ViewMatchers.withId(checkpProgrammer)
    }
    fun getcheckQa (): Matcher<View>? {
        return  ViewMatchers.withId(checkpQa)
    }

    fun getcheckAutomation(): Matcher<View>? {
        return  ViewMatchers.withId(checkAutomation)
    }
}