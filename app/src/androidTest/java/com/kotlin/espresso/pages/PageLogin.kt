package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import org.hamcrest.Matcher

class PageLogin {

    private var email = R.id.input_email
    private var password = R.id.input_password
    private var loginButton = R.id.btn_login
    private var registerLink = R.id.link_register

    fun getInputEmail() : Matcher<View>? {
        return  ViewMatchers.withId(email)
    }

    fun getInputPassword() : Matcher<View>? {
        return  ViewMatchers.withId(password)
    }

    fun getLoginButton() : Matcher<View>? {
        return  ViewMatchers.withId(loginButton)
    }

    fun getRegisterLink() : Matcher<View>? {
        return  ViewMatchers.withId(registerLink)
    }

}