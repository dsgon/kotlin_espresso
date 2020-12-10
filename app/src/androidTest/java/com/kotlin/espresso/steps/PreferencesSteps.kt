package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import com.kotlin.espresso.pages.HomePage
import com.kotlin.espresso.pages.PreferencesPage
import com.kotlin.espresso.views.MenuOptions

class PreferencesSteps  : BaseSteps() {

    var page = PreferencesPage()


    fun verifyPreferencesPage() {
        Espresso.onView(ViewMatchers.withId(R.id.title_option)).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.title_programmer)).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.title_qa)).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.title_automation)).check(ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
    }

    fun checkProgrammerOption(){
        Espresso.onView(
                page.getcheckProgrammer()
        ).perform(ViewActions.click())
    }

    fun checkQaOption(){
        Espresso.onView(
                page.getcheckQa()
        ).perform(ViewActions.click())
    }

    fun checkAutomationOption(){
        Espresso.onView(
                page.getcheckAutomation()
        ).perform(ViewActions.click())
    }

    fun selectPreferencesOptionMenu(){
        selectOptionMenu(MenuOptions.PREFERENCES.value)
    }

    fun selectLogoutOptionMenu(){
        selectOptionMenu(MenuOptions.LOGOUT.value)
    }
}

