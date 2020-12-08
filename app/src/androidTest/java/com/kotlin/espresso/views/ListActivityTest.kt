package com.kotlin.espresso.views

import android.app.ListActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.kotlin.espresso.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ListActivityTest {

    @get: Rule
    val activitiRule = ActivityScenarioRule(ListActivity::class.java)

    @Test
    fun test_ListVisible() {
        onView(withId(R.id.list_courses)).check(matches(isDisplayed()))
    }

}