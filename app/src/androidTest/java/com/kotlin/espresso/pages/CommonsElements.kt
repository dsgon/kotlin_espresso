package com.kotlin.espresso.pages

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher

open class CommonsElements {

    var menu = R.id.action_bar
    var inputEmail = R.id.input_email
    var inputPassword = R.id.input_password

    fun getMenu(): Matcher<View>{
        return ViewMatchers.withId(menu)
    }

    fun getInputEmail(): Matcher<View>? {
        return  ViewMatchers.withId(inputEmail)
    }

    fun getInputPassword(): Matcher<View>? {
        return  ViewMatchers.withId(inputPassword)
    }


}