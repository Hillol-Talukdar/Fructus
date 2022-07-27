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


