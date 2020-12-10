package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import kotlinx.android.synthetic.main.activity_login.view.*
import kotlinx.android.synthetic.main.activity_sign_up.view.*
import org.hamcrest.Matcher

class LoginPage {
    var email = R.id.input_email
    var password = R.id.input_password
    var signUpButton = R.id.btn_sign_up
    var loginButton = R.id.link_register

    fun getEmail(): Matcher<View>? {
        return  ViewMatchers.withId(email)
    }
    fun getpassword(): Matcher<View>? {
        return  ViewMatchers.withId(password)
    }
    fun getsignUpButton(): Matcher<View>? {
        return  ViewMatchers.withId(signUpButton)
    }

}