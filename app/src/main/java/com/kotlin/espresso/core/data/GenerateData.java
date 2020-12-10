package com.kotlin.espresso.core.data;

import android.app.ListActivity;

import java.util.ArrayList;

public class GenerateData {

    private ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<Course> generateData(){
        this.courses.add(new Course("Espresso","https://blog.intive-fdv.com.ar/wp-content/uploads/2016/07/EspressoAndroidGrande.jpg"));
        this.courses.add(new Course("Kotlin","https://trellat.es/wp-content/uploads/logo-kotlin.jpg"));
        this.courses.add(new Course("Android Studio","https://2.bp.blogspot.com/-tzm1twY_ENM/XlCRuI0ZkRI/AAAAAAAAOso/BmNOUANXWxwc5vwslNw3WpjrDlgs9PuwQCLcBGAsYHQ/s1600/pasted%2Bimage%2B0.png"));
        this.courses.add(new Course("JUnit","https://camo.githubusercontent.com/2f40a6b0bcd582469349f8c1e74773c0da5c1ac32c1822dd4102f5f505187a6a/68747470733a2f2f7777772e6c616d626461746573742e636f6d2f626c6f672f77702d636f6e74656e742f75706c6f6164732f323032302f30382f6a756e69742e706e67"));
        this.courses.add(new Course("Gradle","https://dwglogo.com/wp-content/uploads/2017/12/Gradle_logo_02.png"));
        this.courses.add(new Course("Git","https://github.githubassets.com/images/modules/logos_page/Octocat.png"));
        this.courses.add(new Course("Appium","https://itcraftapps.com/wp-content/uploads/2019/05/Appium.png"));
        this.courses.add(new Course("Selenium","https://www.selenium.dev/images/selenium_logo_large.png"));
        return this.courses;
    }

}
