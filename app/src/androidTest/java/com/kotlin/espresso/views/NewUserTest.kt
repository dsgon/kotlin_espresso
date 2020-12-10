package com.kotlin.espresso.views

import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.steps.*
import org.junit.Rule
import org.junit.Test

class NewUserTest {
    @Rule
    @JvmField
    var loginActivityRule = ActivityTestRule<LoginActivity>(
            LoginActivity::class.java
    )

    @Test
    fun newUserFlow(){

        var stepsLogin = LoginSteps()
        var stepsSignUp = SignUpSteps()
        var stepsHome = HomeSteps()
        var stepsPreferences = PreferencesSteps()
        var stepsCourses = CourseSteps()

        stepsLogin.verifyLoginPage()
        stepsLogin.clickSingUpLink()
        stepsSignUp.setUser("luiscouto")
        stepsSignUp.setEmail ("test@gmail.com")
        stepsSignUp.setPassword("12345678")
        stepsSignUp.closeKeyboard()
        stepsSignUp.setConfirm("12345678")
        stepsSignUp.closeKeyboard()
        stepsSignUp.clickBtnSignUp()
        stepsHome.verifyHomePage()
        stepsHome.openMenu()
        stepsPreferences.selectPreferencesOptionMenu()
        stepsPreferences.verifyPreferencesPage()
        stepsPreferences.checkProgrammerOption()
        stepsPreferences.checkQaOption()
        stepsPreferences.pressBack()
        stepsHome.verifyHomePage()
        stepsHome.clickCoursesButton()
        stepsCourses.verifyListCoursesPage()
        stepsCourses.selectGitCourse()
        stepsCourses.verifyCourseInfo()
    }
}