package com.kotlin.espresso.steps

import com.kotlin.espresso.pages.WelcomeActivityPage

class WelcomeActivitySteps {
    fun waitWelcomePageLoad() {
        Thread.sleep(3000)
    }

    class WelcomeActivitySteps : BaseSteps(){

        var welcomePage = WelcomeActivityPage()


    }
}