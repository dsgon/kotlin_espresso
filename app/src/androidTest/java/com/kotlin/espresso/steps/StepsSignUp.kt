package com.kotlin.espresso.steps

import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.core.helper.ErrorMessage
import com.kotlin.espresso.pages.ErrorMessages
import com.kotlin.espresso.pages.PageSignUp

class StepsSignUp : BaseSteps() {

    private var pageSignUp = PageSignUp()

    fun validateUserIsDisplayed() : StepsSignUp{
        Espresso.onView(pageSignUp.getInputUser())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun validateEmailIsDisplayed() : StepsSignUp{
        Espresso.onView(pageSignUp.getInputEmail())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun validatePasswordIsDisplayed() : StepsSignUp{
        Espresso.onView(pageSignUp.getInputPassword())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun validateConfirmPasswordIsDisplayed() : StepsSignUp{
        Espresso.onView(pageSignUp.getInputConfirmPassword())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun setUser(user : String) : StepsSignUp {
        this.validateUserIsDisplayed()
        Espresso.onView(pageSignUp.getInputUser()).perform(ViewActions.typeText(user), ViewActions.pressImeActionButton())
        return this
    }

    fun setEmail(email : String) : StepsSignUp {
        this.validateEmailIsDisplayed()
        Espresso.onView(pageSignUp.getInputEmail()).perform(ViewActions.typeText(email), ViewActions.pressImeActionButton())
        return this
    }

    fun setPassword(password : String) : StepsSignUp {
        this.validatePasswordIsDisplayed()
        Espresso.onView(pageSignUp.getInputPassword()).perform(ViewActions.typeText(password), ViewActions.pressImeActionButton())
        return this
    }

    fun setConfirmPassword(password : String) : StepsSignUp {
        this.validateConfirmPasswordIsDisplayed()
        Espresso.onView(pageSignUp.getInputConfirmPassword()).perform(ViewActions.typeText(password), ViewActions.pressImeActionButton())
        return this
    }

    fun clickSignUpButton(){
        Espresso.onView(pageSignUp.getSignUpButton()).perform(ViewActions.click())
    }

    fun clickLoginLink(){
        Espresso.onView(pageSignUp.getLoginLink()).perform(ViewActions.click())
    }

    fun validateLoginErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>) : StepsSignUp {
        validateToastMessage(activityRule, ErrorMessages().getLoginError())
        return this
    }

    fun validateGeneralErrorMessage(activityRule : ActivityTestRule<AppCompatActivity>) : StepsSignUp {
        validateToastMessage(activityRule, ErrorMessages().getGeneralError())
        return this
    }

    fun validateUserNameEmptyErrorMessage() : StepsSignUp {
        validateErrorOnField(pageSignUp.getInputUser(), ErrorMessage.USERNAME_EMPTY_ERROR)
        return this
    }

    fun validateUserNameSpecialCharsErrorMessage() : StepsSignUp {
        validateErrorOnField(pageSignUp.getInputUser(), ErrorMessage.USERNAME_SPECIAL_CHARS_ERROR)
        return this
    }

    fun validateEmailEmptyErrorMessage() : StepsSignUp {
        validateErrorOnField(pageSignUp.getInputEmail(), ErrorMessage.EMAIL_EMPTY_ERROR)
        return this
    }

    fun validateEmailInvalidErrorMessage() : StepsSignUp {
        validateErrorOnField(pageSignUp.getInputEmail(), ErrorMessage.EMAIL_INVALID_ERROR)
        return this
    }

    fun validatePasswordEmptyErrorMessage() : StepsSignUp {
        validateErrorOnField(pageSignUp.getInputPassword(), ErrorMessage.PASS_EMPTY_ERROR)
        return this
    }

    fun validatePasswordLengthErrorMessage() : StepsSignUp {
        validateErrorOnField(pageSignUp.getInputPassword(), ErrorMessage.PASS_LENGTH_ERROR)
        return this
    }

    fun validateConfirmPasswordEmptyErrorMessage() : StepsSignUp {
        validateErrorOnField(pageSignUp.getInputConfirmPassword(), ErrorMessage.REPEAT_PASS_EMPTY_ERROR)
        return this
    }

    fun validateConfirmPasswordMismatchErrorMessage() : StepsSignUp {
        validateErrorOnField(pageSignUp.getInputConfirmPassword(), ErrorMessage.REPEAT_PASS_DOESNT_MATCH_ERROR)
        return this
    }

}