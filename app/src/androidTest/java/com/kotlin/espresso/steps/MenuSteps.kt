package com.kotlin.espresso.steps

import android.view.View
import android.view.ViewGroup
import androidx.core.content.MimeTypeFilter.matches
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isNotChecked
import com.kotlin.espresso.R
import com.kotlin.espresso.pages.MenuPage
import com.kotlin.espresso.pages.PageSignUp
import com.kotlin.espresso.views.MenuOptions
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher

class MenuSteps {
    var page = MenuPage()
    fun openPreferencesActivity() {
        selectOptionMenu(MenuOptions.PREFERENCES.value)
        Espresso.onView(ViewMatchers.withId(R.id.title_option)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }
    fun logOutActivity() {
        selectOptionMenu(MenuOptions.LOGOUT.value)


    }


    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }


    private fun selectOptionMenu(menu_option: String) {
        var option = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.title), ViewMatchers.withText(menu_option),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.content),
                        position = 0
                    ),
                    position = 0
                ),
                ViewMatchers.isDisplayed()
            )
        )
        option.perform(ViewActions.click())
    }
    fun selectProgrammerOption() {
        Espresso.onView(page.getProgrammerOption())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(page.getProgrammerOption()).perform(ViewActions.click())

    }
    fun selectQAOption() {

        Espresso.onView(page.getQAOption())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            Espresso.onView(page.getQAOption()).perform(ViewActions.click())

    }
    fun selectAutomationOption() {
        Espresso.onView(page.getAutomationOption())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(page.getAutomationOption()).perform(ViewActions.click())

    }

}