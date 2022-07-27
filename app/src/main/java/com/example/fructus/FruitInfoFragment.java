package com.example.fructus;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class FruitInfoFragment extends Fragment {

    private static final String ARG_PARAM1 = "fruitInfo";
    private Fruit fruit;
    private TextView title;
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
        title = view.findViewById(R.id.fruitTitle);
        title.setText(fruit.getTitle());

        fruitImage = view.findViewById(R.id.fruitImage);

        Glide.with(this)
                .asBitmap()
                .load(getImage(fruit.getImage()))
                .into(fruitImage);

    }

    public int getImage(String imageName) {
        int drawableResourceId = this.getResources().getIdentifier(imageName, "drawable", this.getActivity().getPackageName());
        return drawableResourceId;
    }

}