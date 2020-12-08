package com.kotlin.espresso.pages

import android.view.View
import com.kotlin.espresso.R
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class PageLogin {

    private var image = R.id.logo_wip
    private var title = R.id.title_app
    private var lbEemail = R.id.title_email
    private var inputEmail = R.id.input_email
    private var inputPassword = R.id.input_password
    private var btnLogin = R.id.btn_login
    private var btnSignUp = R.id.link_register

    fun imgLogo(): Matcher<View>? {
        return ViewMatchers.withId(image)
    }

    fun labelTitle(): Matcher<View>? {
        return ViewMatchers.withId(title)
    }

    fun labelEmail(): Matcher<View>? {
        return ViewMatchers.withId(lbEemail)
    }

    fun getInputEmail(): Matcher<View>? {
        return ViewMatchers.withId(inputEmail)
    }

    fun getInputPasword(): Matcher<View>? {
        return ViewMatchers.withId(inputPassword)
    }

    fun btnLogin(): Matcher<View>? {
        return ViewMatchers.withId(btnLogin)
    }

    fun btnSingUp(): Matcher<View>? {
        return ViewMatchers.withId(btnSignUp)
    }

}