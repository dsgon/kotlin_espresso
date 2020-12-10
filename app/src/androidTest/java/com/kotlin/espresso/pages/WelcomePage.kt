package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import kotlinx.android.synthetic.main.activity_home.view.*
import org.hamcrest.Matcher


class WelcomePage {
    var welcomeLogo = R.id.icon_wip
    var signUpButton = R.id.link_register

    fun getWelcomeLogo(): org.hamcrest.Matcher<View>?{
        return ViewMatchers.withId(welcomeLogo)
    }
    fun getSignUpButton(): Matcher<View>?{
        return ViewMatchers.withId(signUpButton)
    }


}