package com.example.fructus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button buttonStart;
    private ViewPager2 introductionScreenViewPager;
    private TabLayout tabIndicator;

    IntroductionViewPageAdapter introductionViewPageAdapter;
    Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_introduction);

        initWidgets();
        setupViewPager();
        setupTabIndicator();
        setOnClickListeners();
    }

    private void initWidgets() {
        buttonStart = (Button) findViewById(R.id.buttonStart);
        introductionScreenViewPager = findViewById(R.id.vpFruitViewPager);
        tabIndicator = (TabLayout) findViewById(R.id.tabIndicator);
    }

    private void setupViewPager () {
        util = new Util();

        introductionViewPageAdapter = new IntroductionViewPageAdapter(this);
        introductionScreenViewPager.setAdapter(introductionViewPageAdapter);
        introductionViewPageAdapter.setItem(util.getAllFruits());
    }

    private void setupTabIndicator() {
//        tabIndicator.setupWithViewPager(introductionScreenViewPager);
        new TabLayoutMediator(tabIndicator, introductionScreenViewPager, (tab, position) -> {
//            tab.setText("Tab " + (position+1));
            tab.setIcon(R.drawable.ic_circle_tab_indicator);
        }).attach();
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