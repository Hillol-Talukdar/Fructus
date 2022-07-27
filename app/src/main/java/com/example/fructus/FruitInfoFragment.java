package com.example.fructus;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class FruitInfoFragment extends Fragment {

    private static final String ARG_PARAM1 = "fruitInfo";
    private View buttonStart;
    private LinearLayout linearlayout;
    private Fruit fruit;
    private TextView title;
    private TextView fruitHeadline;
    private ImageView fruitImage;

    public FruitInfoFragment() {
        // Required empty public constructor
    }

    public static FruitInfoFragment newInstance(Fruit param1) {
        FruitInfoFragment fragment = new FruitInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1,param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            fruit = (Fruit) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fruit_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonStart =  view.findViewById(R.id.buttonStart);
        title =  view.findViewById(R.id.fruitTitle);
        title.setText(fruit.getTitle());

        fruitHeadline = view.findViewById(R.id.fruitHeadline);
        fruitHeadline.setText(fruit.getHeadline());

        fruitImage = view.findViewById(R.id.fruitImage);

        Glide.with(this)
                .asBitmap()
                .load(getImage(fruit.getImage()))
                .into(fruitImage);

        ArrayList<String> gradiantColor = fruit.getGradientColors();

        int[] colors = {Color.parseColor(gradiantColor.get(0)), Color.parseColor(gradiantColor.get(1))};

        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM, colors);
        gd.setCornerRadius(0f);


        linearlayout = (LinearLayout) view.findViewById(R.id.llFragmentFruitInfo);
//        linearlayout.setBackgroundColor(Color.parseColor(gradiantColor.get(0)));

        linearlayout.setBackground(gd);

        setOnClickListeners();
    }

    private void setOnClickListeners() {
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), AllFruitsActivity.class);
                startActivity(intent);
            }
        });
    }

    public int getImage(String imageName) {
        int drawableResourceId = this.getResources().getIdentifier(imageName, "drawable", this.getActivity().getPackageName());
        return drawableResourceId;
    }

}