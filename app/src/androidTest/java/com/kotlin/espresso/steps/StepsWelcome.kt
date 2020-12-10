package com.kotlin.espresso.steps

import com.kotlin.espresso.pages.PageWelcome

class StepsWelcome : BaseSteps() {

    var pageWelcome = PageWelcome()

    fun waitUntilWelcomePageIsGone(){
        Thread.sleep(2500)
    }
}