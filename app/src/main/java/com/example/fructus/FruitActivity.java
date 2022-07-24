package com.example.fructus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FruitActivity extends AppCompatActivity {
    private static final String TAG = "FruitActivity";

    private TextView tvFruitTitle;
    private TextView tvFruitHeadline;
    private TextView tvFruitDescription;
    private TextView tvFruitName;

    private ImageView ivFruitImage;

    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();

        getBookInformation();
    }

    private void initWidgets() {
        tvFruitTitle = (TextView) findViewById(R.id.tvFruitTitle);
        tvFruitHeadline = (TextView) findViewById(R.id.tvFruitHeadline);
        tvFruitDescription = (TextView) findViewById(R.id.tvFruitDescription);
        tvFruitName = (TextView) findViewById(R.id.tvFruitName);

        ivFruitImage = (ImageView) findViewById(R.id.ivFruitImage);
    }

    private void getBookInformation() {
        Intent intent = getIntent();
        util = new Util();
        ArrayList<Fruit> fruits = util.getAllFruits();

        int id = intent.getIntExtra("fruitId", 0);

        for(Fruit fruit : fruits) {
            if(fruit.getId() == id) {

                tvFruitTitle.setText(fruit.getTitle());
                tvFruitHeadline.setText(fruit.getHeadline());
                tvFruitDescription.setText(fruit.getDescription());
                tvFruitName.setText(fruit.getTitle().toUpperCase());

                Glide.with(this)
                        .asBitmap()
                        .load(getImage(fruit.getImage()))
                        .into(ivFruitImage);
            }
        }

    }

    public int getImage(String imageName) {
        int drawableResourceId = this.getResources().getIdentifier(imageName, "drawable", this.getPackageName());
        return drawableResourceId;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}