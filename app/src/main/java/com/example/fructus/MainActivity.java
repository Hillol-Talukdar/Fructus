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

    private ViewPager2 introductionScreenViewPager;
    private TabLayout tabIndicator;

    IntroductionViewPageAdapter introductionViewPageAdapter;
    Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupViewPager();
        setupTabIndicator();
    }

    private void initWidgets() {
        introductionScreenViewPager = findViewById(R.id.vpFruitViewPager);
        tabIndicator = (TabLayout) findViewById(R.id.tabIndicator);
    }

    private void setupViewPager () {
        util = new Util();

        introductionViewPageAdapter = new IntroductionViewPageAdapter(this);
        introductionScreenViewPager.setAdapter(introductionViewPageAdapter);
        introductionViewPageAdapter.setItem(util.getAllFruits().subList(0,5));
    }

    private void setupTabIndicator() {
        new TabLayoutMediator(tabIndicator, introductionScreenViewPager, (tab, position) -> {
            tab.setIcon(R.drawable.ic_tab_icon);

        }).attach();
    }

}