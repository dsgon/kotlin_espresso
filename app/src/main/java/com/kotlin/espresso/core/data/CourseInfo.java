package com.kotlin.espresso.core.data;

public class CourseInfo {


    private static String title;
    private static String imageUrl;
    private static CourseInfo courseInfo;

    public static CourseInfo getInstance(){
        if (courseInfo == null)
            courseInfo = new CourseInfo();
        return courseInfo;
    }

    public void setCourseInfo(String titleRecipe, String imageRecipe){
        this.title = titleRecipe;
        this.imageUrl = imageRecipe;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
