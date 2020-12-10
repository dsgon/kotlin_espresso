package com.kotlin.espresso.test.flowsPOM

import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.core.data.GenerateData
import com.kotlin.espresso.enums.MenuOptions
import com.kotlin.espresso.facade.FacadeLogin
import com.kotlin.espresso.steps.*
import com.kotlin.espresso.views.LoginActivity

import org.junit.Rule
import org.junit.Test

/**
 * 4. Usuario que ya existe, ingresa a la app, va al listado de cursos, luego a Preferencias, apaga
 * la opcion Automation y enciende la de QA, regresa al listado, abre el curso de JUnit y luego
 * hace logout
 */
class Scenario4 {

    @Rule @JvmField
    var activityRule = ActivityTestRule<LoginActivity>(
            LoginActivity::class.java
    )

    @Test
    fun scenario4(){
        FacadeLogin().doLogin("userName@test.com", "12345678")
        StepsHome().clickCourses()
        StepsList().openMenu()
        StepsList().selectOptionMenu(MenuOptions.PREFERENCES.value)
        StepsPreferences().unCheckCheckboxAutomation()
                .checkCheckboxQA()
                .validateCheckBoxAutomationIsUnchecked()
                .validateCheckBoxQAIsChecked()
                .pressBack()
        StepsList().selectCourse(GenerateData().generateData()[3].name)
        StepsCourse().validateImageIsDisplayed()
                .validateCourseName(GenerateData().generateData()[3].name)
                .openMenu()
                .selectOptionMenu(MenuOptions.LOGOUT.value)
        StepsLogin().validateEmailIsDisplayed()
                .validatePasswordIsDisplayed()
                .validateLoginButtonIsDisplayed()
                .validateRegisterLinkIsDisplayed()

    }

}
