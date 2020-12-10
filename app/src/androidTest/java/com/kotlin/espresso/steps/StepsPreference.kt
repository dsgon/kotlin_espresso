package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.kotlin.espresso.R
import com.kotlin.espresso.pages.PagePreference
import org.hamcrest.Matchers.allOf

class StepsPreference : BaseSteps() {

    private var preferencePage = PagePreference()


    // To verify all elements of the page "email@domain.com" "Password"
    fun loginPageVisible(emailTxt: String, passwordTxt: String) {
        onView(preferencePage.chkProgramer())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(preferencePage.chkQa())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(preferencePage.chkAutomation())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    fun tapChkBox(chkBox: String) {
        when (chkBox) {
            "programer" -> onView(preferencePage.chkProgramer())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.click())
            "qa" -> onView(preferencePage.chkQa())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.click())
            "automation" -> onView(preferencePage.chkAutomation())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.click())
        }
    }


    // to click on "Preferences", "About Us", "logOut"
    fun clickPreference(option: String) {
        val appCompatTextView = onView(
            allOf(
                ViewMatchers.withId(R.id.title), withText(option),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.content),
                        0
                    ),
                    0
                ),
                ViewMatchers.isDisplayed()
            )
        )
        appCompatTextView.perform(ViewActions.click())
    }


}
