package com.kotlin.espresso.views

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.R
import com.kotlin.espresso.core.data.GenerateData
import com.kotlin.espresso.steps.ListCoursesSteps
import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CoursesTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<ListActivity>(
        ListActivity::class.java
    )

    @Test
    fun openCourseInfo() {
        Espresso.onView(ViewMatchers.withId(R.id.list_courses)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onData(CoreMatchers.anything())
            .inAdapterView(ViewMatchers.withId(R.id.list_courses))
            .atPosition(7).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.main_title_course)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(ViewMatchers.withId(R.id.main_image_course)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    @Test
    fun openCourse() {
        var courseName = GenerateData().generateData().get(5).name
        Espresso.onView(ViewMatchers.withId(R.id.list_courses)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        ListCoursesSteps().selectCourse(courseName)

        Espresso.onView(ViewMatchers.withId(R.id.main_title_course)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(courseName)
            )
        )


 }

}