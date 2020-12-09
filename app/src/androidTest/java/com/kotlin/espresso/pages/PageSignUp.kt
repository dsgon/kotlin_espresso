package com.kotlin.espresso.pages

import android.view.View
import com.kotlin.espresso.R
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class PageSignUp {

    private var userName = R.id.input_user
    private var email = R.id.input_email
    private var password = R.id.input_password
    private var confirmPassword = R.id.input_password2
    private var signUpButton = R.id.btn_sign_up
    private var loginLink = R.id.link_login

    fun getInputUser(): Matcher<View>? {
        return  ViewMatchers.withId(userName)
    }

    fun getInputEmail(): Matcher<View>? {
        return  ViewMatchers.withId(email)
    }

    fun getInputPassword(): Matcher<View>? {
        return  ViewMatchers.withId(password)
    }

    fun getInputConfirmPassword(): Matcher<View>? {
        return  ViewMatchers.withId(confirmPassword)
    }

    fun getSignUpButton(): Matcher<View>? {
        return  ViewMatchers.withId(signUpButton)
    }

    fun getLoginLink(): Matcher<View>? {
        return  ViewMatchers.withId(loginLink)
    }

}