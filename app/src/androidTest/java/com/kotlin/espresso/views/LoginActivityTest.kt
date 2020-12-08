
import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.Espresso

import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.R
import com.kotlin.espresso.core.helper.ErrorMessage
import com.kotlin.espresso.steps.StepsSignUp
import com.kotlin.espresso.views.LoginActivity
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule @JvmField
    var activityRule = ActivityTestRule<LoginActivity>(
        LoginActivity::class.java
    )

    @Test
    fun verifyLoginActivity(){
        Espresso.onView(ViewMatchers.withId(R.id.logo_wip)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_email)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.input_password)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_login)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.link_register)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed()))
    }

    @Test
    fun validLogin(){
        Espresso.onView(ViewMatchers.withId(R.id.input_email)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed())).perform(ViewActions.typeText("mymail@test.com"))
        Espresso.onView(ViewMatchers.withId(R.id.input_password)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed())).perform(ViewActions.typeText("mypassword123"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.btn_login)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed())).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.text_wip)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed()))
    }

    @Test
    fun invalidMail(){
        Espresso.onView(ViewMatchers.withId(R.id.input_email)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed())).perform(ViewActions.typeText("invalidmail.com"))
        Espresso.onView(ViewMatchers.withId(R.id.input_password)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed())).perform(ViewActions.typeText("mypassword123"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.btn_login)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed())).perform(ViewActions.click())
        StepsSignUp().validateLoginErrorMessage(activityRule as ActivityTestRule<AppCompatActivity>)
    }
}