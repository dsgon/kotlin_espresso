package com.kotlin.espresso.flows

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click

import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.R
import com.kotlin.espresso.steps.StepsSignUp
import com.kotlin.espresso.views.HomeActivity
import com.kotlin.espresso.views.MenuOptions
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.junit.Before

import org.junit.Rule
import org.junit.Test

class PreferencesActivityTest {
/*
    1.- Validaciones completa de Formulario de Registro
    2.- Validaciones completa de formulario de Login
    3.- Nuevo usuario con la aplicacion desde cero (Welcome Activity) va a la vista de registro y se registra, va a preferencias, activa la opcion QA y Programmer, luego va a la opcion de Cursos y selecciona el curso de Git
    4.- Usuario que ya existe, ingresa a la app, va al listado de cursos, luego a Preferencias, apaga la opcion Automation y enciende la de QA, regresa al listado, abre el curso de JUnit y luego hace logout

 */

    @Rule @JvmField
    var activityRule = ActivityTestRule<HomeActivity>(
        HomeActivity::class.java
    )

    @Before
    fun setup(){
        StepsSignUp().openMenu()
    }

    @Test
    fun openPreferencesActivity(){
        selectOptionMenu(MenuOptions.PREFERENCES.value)
        Espresso.onView(ViewMatchers.withId(R.id.title_option)).check(ViewAssertions.matches(
            ViewMatchers.isDisplayed()))
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



    private fun selectOptionMenu(menu_option:String){
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
        option.perform(click())
    }

}
