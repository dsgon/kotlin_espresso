package com.kotlin.espresso.pages

import android.view.View
import com.kotlin.espresso.R
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class PageSignUp {

    private var image = R.id.logo_wip
    private var title = R.id.title_app
    private var titleUserName = R.id.title_user
    private var inputUser = R.id.input_user
    private var titleUserEmail = R.id.title_user
    private var inpuEmail = R.id.input_email
    private var titlePassword = R.id.title_user
    private var inputPassword = R.id.input_password
    private var inputRepetePassword = R.id.input_password2
    private var btnSignUp = R.id.btn_sign_up
    private var btnLogin = R.id.link_login

    fun imgLogo(): Matcher<View>? {
        return ViewMatchers.withId(image)
    }

    fun labelTitle(): Matcher<View>? {
        return ViewMatchers.withId(title)
    }

    fun labelUserName(): Matcher<View>? {
        return ViewMatchers.withId(titleUserName)
    }

    fun labelUserEmail(): Matcher<View>? {
        return ViewMatchers.withId(titleUserEmail)
    }

    fun labelUserPassword(): Matcher<View>? {
        return ViewMatchers.withId(titlePassword)
    }

    fun getInputUser(): Matcher<View>? {
        return ViewMatchers.withId(inputUser)
    }

    fun getInputEmail(): Matcher<View>? {
        return ViewMatchers.withId(inpuEmail)
    }

    fun getInputPasword(): Matcher<View>? {
        return ViewMatchers.withId(inputPassword)
    }

    fun getInputRepeatPasword(): Matcher<View>? {
        return ViewMatchers.withId(inputRepetePassword)
    }

    fun clickRegister(): Matcher<View>? {
        return ViewMatchers.withId(btnSignUp)
    }

    fun clickLinkLogin(): Matcher<View>? {
        return ViewMatchers.withId(btnLogin)
    }

}