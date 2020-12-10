package com.kotlin.espresso.views

import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.steps.*
import org.junit.Rule
import org.junit.Test

class ExistingUserTest
{
    @Rule
    @JvmField
    var loginActivityRule = ActivityTestRule<LoginActivity>(
            LoginActivity::class.java
    )

    @Test
    fun existingUserFlow(){

        var stepsLogin = LoginSteps()
        var stepsHome = HomeSteps()
        var stepsPreferences = PreferencesSteps()
        var stepsCourses = CourseSteps()

        stepsLogin.verifyLoginPage()
        stepsLogin.setEmail ("emailvalid@gmail.com")
        stepsLogin.setPassword ("12345678")
        stepsLogin.closeKeyboard()
        stepsLogin.clickLoginButton()
        stepsHome.verifyHomePage()
        stepsHome.clickCoursesButton()
        stepsCourses.verifyListCoursesPage()
        stepsCourses.openMenu()
        stepsPreferences.selectPreferencesOptionMenu()
        stepsPreferences.verifyPreferencesPage()
        stepsPreferences.checkAutomationOption()
        stepsPreferences.checkQaOption()
        stepsPreferences.pressBack()
        stepsCourses.verifyListCoursesPage()
        stepsCourses.selectJUnitCourse()
        stepsCourses.verifyCourseInfo()
        stepsHome.openMenu()
        stepsPreferences.selectLogoutOptionMenu()
        stepsLogin.verifyLoginPage()
    }

}