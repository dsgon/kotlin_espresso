package com.kotlin.espresso.facade

import com.kotlin.espresso.steps.StepsLogin

class FacadeLogin {

    private var stepsLogin = StepsLogin()

    fun doLogin(email: String, password: String) {
        stepsLogin.setEmail(email)
        stepsLogin.setPassword(password)
        stepsLogin.closeSoftKeyboard()
        stepsLogin.clickLoginButton()
    }

}