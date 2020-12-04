package com.kotlin.espresso.views;

import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.kotlin.espresso.R;

public class WelcomeActivity extends AppCompatActivity {

    private Handler hold = new Handler();
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        hold.postDelayed(new Runnable() {
            @Override
            public void run() {
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
