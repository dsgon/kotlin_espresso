package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import org.hamcrest.Matcher

class LoginPage {

    private var loginImg = R.id.logo_wip
    private var loginTitle = R.id.title_app
    private var emailInput = R.id.input_email
    private var passwordInput = R.id.input_password
    private var loginBtn = R.id.btn_login
    var signUpLink = R.id.link_register

    fun getLoginImg() : Matcher<View>? {
        return  ViewMatchers.withId(loginImg)
    }

    fun getLoginTitle() : Matcher<View>? {
        return  ViewMatchers.withId(loginTitle)
    }

    fun getEmailInput() : Matcher<View>? {
        return  ViewMatchers.withId(emailInput)
    }

    fun getPasswordInput() : Matcher<View>? {
        return  ViewMatchers.withId(passwordInput)
    }

    fun getLoginBtn() : Matcher<View>? {
        return  ViewMatchers.withId(loginBtn)
    }

    fun getSignUpLink() : Matcher<View>? {
        return  ViewMatchers.withId(signUpLink)
    }

}