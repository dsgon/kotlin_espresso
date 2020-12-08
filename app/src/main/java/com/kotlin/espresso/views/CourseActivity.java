package com.kotlin.espresso.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.kotlin.espresso.R;
import com.kotlin.espresso.core.data.CourseInfo;
import com.kotlin.espresso.core.helper.ImageHandler;



public class CourseActivity extends AppCompatActivity {

    ImageView imageCourse;
    TextView titleCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        imageCourse = findViewById(R.id.main_image_course);
        titleCourse = findViewById(R.id.main_title_course);
        loadInfo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case  R.id.option_preferences:
                intent = new Intent(this, PreferenceActivity.class);
                startActivity(intent);
                break;
            case  R.id.option_about_us:
                intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                break;
            case R.id.action_logout:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadInfo(){
        imageCourse.setImageBitmap(ImageHandler.getImageFromUrl(CourseInfo.getInstance().getImageUrl()));
        titleCourse.setText(CourseInfo.getInstance().getTitle());
    }
}
