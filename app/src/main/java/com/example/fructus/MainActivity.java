package com.example.fructus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button buttonStart;
    private ViewPager2 introductionScreenPager;
    IntroductionViewPageAdapter introductionViewPageAdapter;
    FruitsRecyclerViewAdapter fruitsRecyclerViewAdapter;
    Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_introduction);

        initWidgets();
        setupViewPager();
        setOnClickListeners();
    }

    private void initWidgets() {
        buttonStart = (Button) findViewById(R.id.buttonStart);
        introductionScreenPager = findViewById(R.id.vpFruitViewPager);
    }

    private void setupViewPager () {
        util = new Util();

        introductionViewPageAdapter = new IntroductionViewPageAdapter(this);
        introductionScreenPager.setAdapter(introductionViewPageAdapter);
        introductionViewPageAdapter.setItem(util.getAllFruits());
    }

    private void setOnClickListeners() {
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllFruitsActivity.class);
                startActivity(intent);
            }
        });
    }
}