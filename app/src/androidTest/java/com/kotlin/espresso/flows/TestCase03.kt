package com.kotlin.espresso.flows

import android.os.SystemClock.sleep
import androidx.test.rule.ActivityTestRule
import com.kotlin.espresso.steps.*
import com.kotlin.espresso.views.WelcomeActivity
import org.junit.Rule
import org.junit.Test

class TestCase03 {


    // 3.- Nuevo usuario con la aplicacion desde cero (Welcome Activity) va a la vista de registro y se registra, va a preferencias, activa la opcion QA y Programmer, luego va a la opcion de Cursos y selecciona el curso de Git


    @Rule
    @JvmField
    var activityRule = ActivityTestRule<WelcomeActivity>(
        WelcomeActivity::class.java
    )

    @Test
    fun registerFlowUser() {
        sleep(5000)
        StepsLogin().tapSingUp()
        StepsSignUp().setUser("Pedro", "test@email.com", "12345678", "12345678")
        StepsSignUp().openMenu()
        StepsPreference().clickPreference("Preferences")
        StepsPreference().tapChkBox("qa")
        StepsPreference().tapChkBox("programer")
        StepsPreference().pressBack()
        StepsHome().tapCourses()
        StepsListCourses().selectCourseByIndex(4)
    }


}