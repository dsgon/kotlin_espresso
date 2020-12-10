package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import org.hamcrest.Matcher

class SignUpPage : CommonsElements() {

    var inputUser = R.id.input_user
    var inputConfirm = R.id.input_password2
    var btnSignUp = R.id.btn_sign_up
    var linkLogin = R.id.link_login

    fun getInputUser(): Matcher<View>? {
        return  ViewMatchers.withId(inputUser)
    }
    fun getinputConfirm(): Matcher<View>? {
        return  ViewMatchers.withId(inputConfirm)
    }

    fun getbtnSignUp(): Matcher<View>? {
        return  ViewMatchers.withId(btnSignUp)
    }

    fun getlinkLogin(): Matcher<View>? {
        return  ViewMatchers.withId(linkLogin)
    }
}