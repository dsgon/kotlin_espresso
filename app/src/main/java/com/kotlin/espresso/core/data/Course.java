package com.kotlin.espresso.core.data;

public class Course {

    private String name;
    private String image;

    public Course(String name, String image){
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

}
