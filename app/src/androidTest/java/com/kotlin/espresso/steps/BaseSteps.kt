package com.kotlin.espresso.steps


import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.R

import com.kotlin.espresso.pages.CommonsElements
import org.hamcrest.*
import org.hamcrest.CoreMatchers.not


open class BaseSteps {

    fun closeSoftKeyboard(){
        Espresso.closeSoftKeyboard()
    }

    fun pressBack(){
        Espresso.pressBack()
    }

    protected fun validateToastMessage(activityRule : ActivityTestRule<AppCompatActivity>, message : Matcher<View>?){
        Espresso.onView(message).inRoot(
            RootMatchers.withDecorView(not(
                CoreMatchers.`is`(activityRule.activity.window.decorView)
            ))).check(
            ViewAssertions.matches(
            ViewMatchers.isDisplayed()))
    }

    protected fun validateErrorOnField(element: Matcher<View>?, error: String){
        Espresso.onView(element).check(ViewAssertions.matches(ViewMatchers.hasErrorText(error)))
    }

    fun openMenu() : BaseSteps {
        var menu = Espresso.onView(
            Matchers.allOf(
            ViewMatchers.withContentDescription("More options"),
            childAtPosition(
                childAtPosition(
                    CommonsElements().getMenu(),
                    position = 1
                ),
                position = 0
            ),
            ViewMatchers.isDisplayed()
        ))
        menu.perform(ViewActions.click())
        return this
    }

    fun selectOptionMenu(menu_option:String){
        var option = Espresso.onView(Matchers.allOf(
                ViewMatchers.withId(R.id.title), ViewMatchers.withText(menu_option),
                childAtPosition(
                        childAtPosition(
                                ViewMatchers.withId(R.id.content),
                                position = 0
                        ),
                        position = 0
                ),
                ViewMatchers.isDisplayed()
        ))
        option.perform(ViewActions.click())
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