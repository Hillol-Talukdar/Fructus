package com.example.fructus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class AllFruitsActivity extends AppCompatActivity {
    private static final String TAG = "AllFruitsActivity";

    private RecyclerView fruitRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_fruits);

        fruitRecycleView = (RecyclerView) findViewById(R.id.fruitRecycleView);

        FruitsRecyclerViewAdapter adapter = new FruitsRecyclerViewAdapter(this);
        fruitRecycleView.setAdapter(adapter);
        fruitRecycleView.setLayoutManager(new LinearLayoutManager(this));


        Util util = new Util();
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits = util.getAllFruits();
        adapter.setFruits(fruits);
    }
}