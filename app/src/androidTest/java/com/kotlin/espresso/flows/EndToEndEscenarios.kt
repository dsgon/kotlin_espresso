package com.kotlin.espresso.flows

import androidx.test.core.app.ActivityScenario
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.config.testData
import com.kotlin.espresso.steps.*
import com.kotlin.espresso.views.HomeActivity
import com.kotlin.espresso.views.LoginActivity
import com.kotlin.espresso.views.WelcomeActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EndToEndEscenarios {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<WelcomeActivity>(
        WelcomeActivity::class.java


    )

    @Before
    fun setup(){
        WelcomeSteps().validateWelcomeLogoIsDisplayed()

        Thread.sleep(3000)

    }
    //escenario 1: Nuevo usuario con la aplicacion desde cero (Welcome Activity) va a la vista de registro y se registra,
    // va a preferencias, activa la opcion QA y Programmer, luego va a la opcion de Cursos y selecciona el curso de Git
    @Test
    fun selectPreferencesAndSelectGitCourse(){
       // val activityScenario = ActivityScenario.launch(HomeActivity::class.java)
        WelcomeSteps().clickSignUpButton()
        StepsSignUp().signUpForm(testData.INPUTUSER,testData.INPUTEMAIL,testData.INPUTPASS,testData.INPUTPASS2)
        StepsSignUp().clickSignUpButton()
        StepsSignUp().openMenu()
        MenuSteps().openPreferencesActivity()
        MenuSteps().selectProgrammerOption()
        MenuSteps().selectQAOption()
        BaseSteps().pressBack()
        HomeSteps().validateHomeLogo()
        HomeSteps().clickCoursesButton()
        ListCoursesSteps().validateCoursesInfo()
        ListCoursesSteps().openCourse(5)

    }
    //Escenario 2: Usuario que ya existe, ingresa a la app, va al listado de cursos, luego a Preferencias,
    // apaga la opcion Automation
    // y enciende la de QA, regresa al listado, abre el curso de JUnit y luego hace logout
    @Test
    fun existingUserSelectsPreferencesAndJunitCourse(){
        LoginSteps().login(testData.INPUTEMAIL,testData.INPUTPASS)
        HomeSteps().clickCoursesButton()
        ListCoursesSteps().validateCoursesInfo()
        StepsSignUp().openMenu()
        MenuSteps().logOutActivity()
        LoginSteps().login(testData.INPUTEMAIL,testData.INPUTPASS)
        HomeSteps().validateHomeLogo()
        StepsSignUp().openMenu()
        MenuSteps().openPreferencesActivity()
        MenuSteps().selectQAOption()
         MenuSteps().selectAutomationOption()
        BaseSteps().pressBack()
        HomeSteps().validateHomeLogo()
        HomeSteps().clickCoursesButton()
        ListCoursesSteps().validateCoursesInfo()
        ListCoursesSteps().openCourse(3)


    }
}
