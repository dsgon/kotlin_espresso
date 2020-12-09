package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.core.helper.ErrorMessage
import org.hamcrest.Matcher

class ErrorMessages {

    fun getLoginError(): Matcher<View>?{
        return ViewMatchers.withText(ErrorMessage.LOGIN_ERROR)
    }

    fun getRegisterError(): Matcher<View>?{
        return ViewMatchers.withText(ErrorMessage.REGISTER_ERROR)
    }

    fun getGeneralError(): Matcher<View>?{
        return ViewMatchers.withText(ErrorMessage.GENERAL_ERROR)
    }

}