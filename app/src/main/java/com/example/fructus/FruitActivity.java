package com.example.fructus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
    private TextView tvLearnMore;

    private ImageView ivFruitImage;

    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();

        getBookInformation();
    }

    private void initWidgets() {
        tvFruitTitle = (TextView) findViewById(R.id.tvFruitTitle);
        tvFruitHeadline = (TextView) findViewById(R.id.tvFruitHeadline);
        tvFruitDescription = (TextView) findViewById(R.id.tvFruitDescription);
        tvFruitName = (TextView) findViewById(R.id.tvFruitName);
        tvLearnMore = (TextView) findViewById(R.id.tvLearnMore);

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



                int[] colors = {Color.parseColor(fruit.getGradientColors().get(0)), Color.parseColor(fruit.getGradientColors().get(1))};

                //create a new gradient color
                GradientDrawable gd = new GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM, colors);
                gd.setCornerRadius(0f);

                ivFruitImage.setBackground(gd);
                tvFruitTitle.setTextColor(Color.parseColor(fruit.getGradientColors().get(1)));
                tvFruitName.setTextColor(Color.parseColor(fruit.getGradientColors().get(0)));
                tvLearnMore.setTextColor(Color.parseColor(fruit.getGradientColors().get(0)));
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