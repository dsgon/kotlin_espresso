package com.kotlin.espresso.test.flowsPOM

import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.core.data.GenerateData
import com.kotlin.espresso.enums.MenuOptions
import com.kotlin.espresso.facade.FacadeSignUp
import com.kotlin.espresso.steps.*
import com.kotlin.espresso.views.WelcomeActivity

import org.junit.Rule
import org.junit.Test

/**
 * 3. Nuevo usuario con la aplicacion desde cero (Welcome Activity) va a la vista de registro y se
 * registra, va a preferencias, activa la opcion QA y Programmer, luego va a la opcion de Cursos y
 * selecciona el curso de Git
 */
class Scenario3 {

    @Rule @JvmField
    var activityRule = ActivityTestRule<WelcomeActivity>(
            WelcomeActivity::class.java
    )

    @Test
    fun scenario3(){
        StepsWelcome().waitUntilWelcomePageIsGone()
        StepsLogin().clickRegisterLink()
        FacadeSignUp().doRegister("userName", "username@test.com", "12345678", "12345678")
        StepsHome().openMenu()
                .selectOptionMenu(MenuOptions.PREFERENCES.value)
        StepsPreferences().checkCheckboxQA()
                .checkCheckboxProgrammer()
                .validateCheckBoxQAIsChecked()
                .validateCheckBoxProgrammerIsChecked()
                .pressBack()
        StepsHome().clickCourses()
        StepsList().selectCourse(GenerateData().generateData()[5].name)
        StepsCourse().validateImageIsDisplayed()
                .validateCourseName(GenerateData().generateData()[5].name)


    }

}
