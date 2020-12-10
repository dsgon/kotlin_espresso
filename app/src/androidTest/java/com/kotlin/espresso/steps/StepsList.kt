package com.kotlin.espresso.steps

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import com.kotlin.espresso.pages.PageList
import org.hamcrest.core.AllOf.allOf

class StepsList : BaseSteps() {

    private var pageList = PageList()

    fun selectCourse(option : String){
        Espresso.onView(allOf(pageList.getOption(option)))
                .perform(ViewActions.scrollTo(), ViewActions.click())
    }

}