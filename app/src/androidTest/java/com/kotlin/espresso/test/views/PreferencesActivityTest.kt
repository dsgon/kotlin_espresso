package com.kotlin.espresso.test.views

import androidx.test.espresso.Espresso

import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.R
import com.kotlin.espresso.views.PreferenceActivity

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PreferencesActivityTest {

    @Rule @JvmField
    var activityRule = ActivityTestRule<PreferenceActivity>(
        PreferenceActivity::class.java
    )

    @Test
    fun verifyPreferencesActivity(){
        Espresso.onView(ViewMatchers.withId(R.id.title_option)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.title_programmer)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.title_qa)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.title_automation)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.checkbox_programmer)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed())).check(ViewAssertions.matches(ViewMatchers.isNotChecked()))
        Espresso.onView(ViewMatchers.withId(R.id.checkbox_qa)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed())).check(ViewAssertions.matches(ViewMatchers.isNotChecked()))
        Espresso.onView(ViewMatchers.withId(R.id.checkbox_automation)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed())).check(ViewAssertions.matches(ViewMatchers.isChecked()))

    }

}