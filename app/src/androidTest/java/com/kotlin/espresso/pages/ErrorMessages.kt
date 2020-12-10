package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.core.helper.ErrorMessage
import org.hamcrest.Matcher

class ErrorMessages {

    // "Verify your email and/or password";
    fun getLoginError(): Matcher<View>?{
        return ViewMatchers.withText(ErrorMessage.LOGIN_ERROR)
    }

    // "Something went wrong. Try Again";
    fun getGeneralError(): Matcher<View>?{
        return ViewMatchers.withText(ErrorMessage.GENERAL_ERROR)
    }

    // "The field Email cannot be empty";
    fun getEmailEmpty(): Matcher<View>?{
        return ViewMatchers.withText(ErrorMessage.EMAIL_EMPTY_ERROR)
    }

}