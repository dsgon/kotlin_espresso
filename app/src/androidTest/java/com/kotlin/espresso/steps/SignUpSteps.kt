package com.kotlin.espresso.steps

import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.pages.ErrorMessages
import com.kotlin.espresso.pages.SignUpPage

class SignUpSteps : BaseSteps() {

    var page = SignUpPage()

    fun setUser(user : String){
        Espresso.onView(
            page.getInputUser()
        ).perform(ViewActions.typeText(user))
    }

    fun validateLoginErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>){
        validateToastMessage(activityRule,ErrorMessages().getLoginError())
    }
}