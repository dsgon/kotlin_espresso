package com.kotlin.espresso.pages

import android.view.View
import com.kotlin.espresso.R
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class PageSignUp {

    var inputUser = R.id.input_user

        fun getInputUser(): Matcher<View>? {
        return  ViewMatchers.withId(inputUser)
    }
}