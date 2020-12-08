package com.kotlin.espresso.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.kotlin.espresso.R;
import com.kotlin.espresso.core.adapter.Adapter;
import com.kotlin.espresso.core.data.Course;
import com.kotlin.espresso.core.data.CourseInfo;
import com.kotlin.espresso.core.data.GenerateData;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ArrayList<Course> courses = new ArrayList<Course>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        courses = new GenerateData().generateData();
        ListView listMatches = (ListView) findViewById(R.id.list);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        Adapter matchAdapter = new Adapter(getApplicationContext(), courses);
        listMatches.setAdapter(matchAdapter);
        listMatches.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                setCourseInfo(i);
                Intent intent = new Intent(getApplicationContext(), CourseActivity.class);
                startActivity(intent);
            }
            });

    }

    private void setCourseInfo(int index){
        String name = courses.get(index).getName();
        String image = courses.get(index).getImage();
        CourseInfo.getInstance().setCourseInfo(name,image);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent ;
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
}
