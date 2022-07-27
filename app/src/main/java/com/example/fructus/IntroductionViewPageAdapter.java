package com.example.fructus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
public class IntroductionViewPageAdapter extends FragmentStateAdapter {

    private final ArrayList<Fruit> introductionScreenItems = new ArrayList<>();

    public IntroductionViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    public void setItem(ArrayList<Fruit> introductionScreenItems) {
        this.introductionScreenItems.clear();
        this.introductionScreenItems.addAll(introductionScreenItems);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return  FruitInfoFragment.newInstance(introductionScreenItems.get(position));
    }

    @Override
    public int getItemCount() {
        return introductionScreenItems.size();
    }
}

  class sss extends PagerAdapter {
    Context context;
    private final ArrayList<Fruit> introductionScreenItems = new ArrayList<>();
    private Util utils;

    public sss(Context context) {
        utils = new Util();
        this.context = context;

    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_introduction_screen, null);

        ImageView ivIntroductionImage = layoutScreen.findViewById(R.id.ivIntroductionImage);
        TextView tvIntroductionTitle = layoutScreen.findViewById(R.id.tvIntroductionTitle);
        TextView tvIntroductionHeadLine = layoutScreen.findViewById(R.id.tvIntroductionHeadLine);

        tvIntroductionTitle.setText(introductionScreenItems.get(position).getTitle());
        tvIntroductionHeadLine.setText(introductionScreenItems.get(position).getHeadline());


        Glide.with(context)
                .asBitmap()
                .load(getImage(introductionScreenItems.get(position).getImage()))
                .into(ivIntroductionImage);

        container.addView(layoutScreen);

        return layoutScreen;

    }

    public int getImage(String imageName) {
        int drawableResourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        return drawableResourceId;
    }


    @Override
    public int getCount() {
        return introductionScreenItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public void setItem(ArrayList<Fruit> introductionScreenItems) {
        this.introductionScreenItems.clear();
        this.introductionScreenItems.addAll(introductionScreenItems);
        notifyDataSetChanged();
    }
}

