package com.kotlin.espresso.steps

import android.text.method.Touch.scrollTo
import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import com.kotlin.espresso.pages.PageListCourses
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher

class StepsListCourses {

    private var listCoursesPage = PageListCourses()


    fun selectCourse(options: String) {
        // onView(allOf(listCoursesPage.(options))).perform(scrollTo()).perform(click())
    }

    fun verifyElements() {
        onView(listCoursesPage.labelTitle())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(listCoursesPage.listCourses())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun selectCourseByIndex(index: Int) {
        val linearLayout = Espresso.onData(Matchers.anything())
            .inAdapterView(
                Matchers.allOf(
                    ViewMatchers.withId(R.id.list_courses),
                    childAtPosition(
                        ViewMatchers.withClassName(Matchers.`is`("android.widget.LinearLayout")),
                        1
                    )
                )
            )
            .atPosition(index)
        linearLayout.perform(click())
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


}