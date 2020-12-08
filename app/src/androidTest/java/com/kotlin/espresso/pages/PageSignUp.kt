package com.kotlin.espresso.pages

import android.view.View
import com.kotlin.espresso.R
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class PageSignUp {

    private var inputUser = R.id.input_user
    private var inpuEmail = R.id.input_email
    private var inputPassword = R.id.input_password
    private var inputRepetePassword = R.id.input_password2
    private var btnSignUp = R.id.btn_sign_up
    private var btnLogin = R.id.link_login

    fun getInputUser(): Matcher<View>? {
        return  ViewMatchers.withId(inputUser)
    }

    fun getInputEmail(): Matcher<View>? {
        return  ViewMatchers.withId(inpuEmail)
    }

    fun getInputPasword(): Matcher<View>? {
        return  ViewMatchers.withId(inputPassword)
    }

    fun getInputRepeatPasword(): Matcher<View>? {
        return  ViewMatchers.withId(inputRepetePassword)
    }

    fun clickRegister(): Matcher<View>? {
        return  ViewMatchers.withId(btnSignUp)
    }

    fun getLinkLogin(): Matcher<View>? {
        return  ViewMatchers.withId(btnLogin)
    }

}