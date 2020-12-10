package com.kotlin.espresso.pages

import android.view.View
import com.kotlin.espresso.R
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class PageSignUp {


    private var userSignUp = R.id.input_user
    private var inpuEmailSignUp = R.id.input_email
    private var inputPasswordSignUp = R.id.input_password
    private var confirmPasswordSignUp = R.id.input_password2
    private var signUpBtn = R.id.btn_sign_up
    private var loginBtn = R.id.link_login


    fun getInputUser(): Matcher<View>? {
        return ViewMatchers.withId(userSignUp)
    }

    fun getInputEmail(): Matcher<View>? {
        return ViewMatchers.withId(inpuEmailSignUp)
    }

    fun getInputPassword(): Matcher<View>? {
        return ViewMatchers.withId(inputPasswordSignUp)
    }

    fun getInputPassConfirmation(): Matcher<View>? {
        return ViewMatchers.withId(confirmPasswordSignUp)
    }

    fun clickRegister(): Matcher<View>? {
        return ViewMatchers.withId(signUpBtn)
    }

    fun clickLoginBtn(): Matcher<View>? {
        return ViewMatchers.withId(loginBtn)
    }


}