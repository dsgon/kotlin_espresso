package com.kotlin.espresso.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.core.helper.ErrorMessage
import org.hamcrest.Matcher

class ErrorMessages {

    fun getEmptyUserError(): Matcher<View>?{
        return ViewMatchers.withText(ErrorMessage.USERNAME_EMPTY_ERROR)
    }
    fun getEmptyEmailError(): Matcher<View>?{
        return ViewMatchers.withText(ErrorMessage.EMAIL_EMPTY_ERROR)
    }
    fun getEmptyPasswordError(): Matcher<View>?{
        return ViewMatchers.withText(ErrorMessage.PASS_EMPTY_ERROR)
    }
    fun getEmptyRepeatPasswordError(): Matcher<View>?{
        return ViewMatchers.withText(ErrorMessage.REPEAT_PASS_EMPTY_ERROR)
    }
    fun getLoginError(): Matcher<View>?{
        return ViewMatchers.withText(ErrorMessage.LOGIN_ERROR)
    }

    fun getInvalidUserError(): Matcher<View>?{
        return ViewMatchers.withText(ErrorMessage.USERNAME_SPECIAL_CHARS_ERROR)
    }

    fun getInvalidEmailError(): Matcher<View>?{
        return ViewMatchers.withText(ErrorMessage.EMAIL_INVALID_ERROR)
    }

    fun getInvalidPasswordError(): Matcher<View>?{
        return ViewMatchers.withText(ErrorMessage.PASS_LENGTH_ERROR)
    }

    fun getPasswordMissmatchError() : Matcher<View>?{

        return ViewMatchers.withText(ErrorMessage.REPEAT_PASS_DOESNT_MATCH_ERROR)
    }
}