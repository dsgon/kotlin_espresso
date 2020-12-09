package com.kotlin.espresso.facade

import com.kotlin.espresso.steps.StepsSignUp

class FacadeSignUp {

    private var stepsSignUp = StepsSignUp()

    fun doRegister(userName: String, email: String, password: String, confirmPassword: String) {
        stepsSignUp.setUser(userName)
        stepsSignUp.setEmail(email)
        stepsSignUp.setPassword(password)
        stepsSignUp.setConfirmPassword(confirmPassword)
        stepsSignUp.closeSoftKeyboard()
        stepsSignUp.clickSignUpButton()
    }

}