package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R

import org.hamcrest.Matcher

class LoginPage  : CommonsElements() {

    var buttonLogin = R.id.btn_login
    var linkRegister = R.id.link_register
    var logoWip = R.id.logo_wip

    fun getLogoWip(): Matcher<View>? {
        return  ViewMatchers.withId(logoWip)
    }

    fun getButtonLogin(): Matcher<View>? {
        return  ViewMatchers.withId(buttonLogin)
    }

    fun getLinkRegister(): Matcher<View>? {
        return  ViewMatchers.withId(linkRegister)
    }

}