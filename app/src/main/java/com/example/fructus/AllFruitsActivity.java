package com.example.fructus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class AllFruitsActivity extends AppCompatActivity {
    private static final String TAG = "AllFruitsActivity";

    private RecyclerView fruitRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_fruits);

        fruitRecycleView = (RecyclerView) findViewById(R.id.fruitRecycleView);
    }
}