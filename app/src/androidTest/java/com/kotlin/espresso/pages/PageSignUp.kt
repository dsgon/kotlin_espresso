package com.kotlin.espresso.pages

import android.view.View
import android.widget.EditText
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.R
import org.hamcrest.Matcher

class PageSignUp {

    var appLogo = R.id.logo_wip
    var inputUser = R.id.input_user
    var inputEmail = R.id.input_email
    var inputPassword = R.id.input_password
    var inputPassword2 = R.id.input_password2
    var signUpButton = R.id.btn_sign_up


    fun getappLogo(): Matcher<View>? {
        return  ViewMatchers.withId(appLogo)
    }
    fun getInputUser(): Matcher<View>? {
        return  ViewMatchers.withId(inputUser)
    }
    fun getinputEmail(): Matcher<View>? {
        return  ViewMatchers.withId(inputEmail)
    }
    fun getinputPassword(): Matcher<View>? {
        return  ViewMatchers.withId(inputPassword)
    }
    fun getinputPassword2(): Matcher<View>? {
        return  ViewMatchers.withId(inputPassword2)
    }
    fun getsignUpButton(): Matcher<View>? {
        return  ViewMatchers.withId(signUpButton)
    }
}