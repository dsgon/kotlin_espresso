package com.kotlin.espresso.steps

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.kotlin.espresso.pages.PagePreferences
import junit.framework.AssertionFailedError
import org.hamcrest.Matcher

class StepsPreferences : BaseSteps() {

    var pagePreferences = PagePreferences()

    fun validateCheckBoxProgrammerIsDisplayed() : StepsPreferences{
        Espresso.onView(pagePreferences.getCheckboxProgrammer())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun validateCheckBoxQAIsDisplayed() : StepsPreferences{
        Espresso.onView(pagePreferences.getCheckboxQA())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun validateCheckBoxAutomationIsDisplayed() : StepsPreferences{
        Espresso.onView(pagePreferences.getCheckboxAutomation())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun validateCheckBoxProgrammerIsChecked() : StepsPreferences{
        this.validateCheckBoxProgrammerIsDisplayed()
        Espresso.onView(pagePreferences.getCheckboxProgrammer())
                .check(ViewAssertions.matches(ViewMatchers.isChecked()))
        return this
    }

    fun validateCheckBoxQAIsChecked() : StepsPreferences{
        this.validateCheckBoxQAIsDisplayed()
        Espresso.onView(pagePreferences.getCheckboxQA())
                .check(ViewAssertions.matches(ViewMatchers.isChecked()))
        return this
    }

    fun validateCheckBoxAutomationIsUnchecked() : StepsPreferences{
        this.validateCheckBoxAutomationIsDisplayed()
        Espresso.onView(pagePreferences.getCheckboxAutomation())
                .check(ViewAssertions.matches(ViewMatchers.isNotChecked()))
        return this
    }

    fun checkCheckboxProgrammer() : StepsPreferences{
        this.validateCheckBoxProgrammerIsDisplayed()
        if(!this.isCheckBoxChecked(pagePreferences.getCheckboxProgrammer())){
            Espresso.onView(pagePreferences.getCheckboxProgrammer()).perform(ViewActions.click())
        }
        return this
    }

    fun checkCheckboxQA() : StepsPreferences{
        this.validateCheckBoxProgrammerIsDisplayed()
        if(!this.isCheckBoxChecked(pagePreferences.getCheckboxQA())){
            Espresso.onView(pagePreferences.getCheckboxQA()).perform(ViewActions.click())
        }
        return this
    }

    fun unCheckCheckboxAutomation() : StepsPreferences{
        this.validateCheckBoxProgrammerIsDisplayed()
        if(this.isCheckBoxChecked(pagePreferences.getCheckboxAutomation())){
            Espresso.onView(pagePreferences.getCheckboxAutomation()).perform(ViewActions.click())
        }
        return this
    }

    fun isCheckBoxChecked(element: Matcher<View>?) : Boolean {
        return try{
            Espresso.onView(element).check(ViewAssertions.matches(ViewMatchers.isChecked()))
            true
        }catch (e: AssertionFailedError){
            false
        }
    }
}