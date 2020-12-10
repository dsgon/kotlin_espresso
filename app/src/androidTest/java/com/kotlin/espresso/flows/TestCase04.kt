package com.kotlin.espresso.flows

import android.os.SystemClock.sleep
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.steps.*
import com.kotlin.espresso.views.WelcomeActivity
import org.junit.Rule
import org.junit.Test

class TestCase04 {


    // 4.- Usuario que ya existe, ingresa a la app, va al listado de cursos, luego a Preferencias, apaga la opcion Automation y enciende la de QA, regresa al listado, abre el curso de JUnit y luego hace logout


    @Rule
    @JvmField
    var activityRule = ActivityTestRule<WelcomeActivity>(
        WelcomeActivity::class.java
    )

    @Test
    fun loginFlowUser() {
        sleep(5000)
        StepsLogin().loginUser("test@email.com", "12345678")
        StepsHome().tapCourses()
        StepsSignUp().openMenu()
        StepsPreference().clickPreference("Preferences")
        StepsPreference().tapChkBox("automation")
        StepsPreference().tapChkBox("qa")
        StepsPreference().pressBack()
        StepsListCourses().selectCourseByIndex(3)
        StepsSignUp().openMenu()
        StepsPreference().clickPreference("Logout")
    }


}