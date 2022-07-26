package com.example.fructus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class FruitsRecyclerViewAdapter extends RecyclerView.Adapter<FruitsRecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "FruitsRecyclerViewAdapt";

    private ArrayList<Fruit> fruits = new ArrayList<>();
    private Context context;
    private Util utils;

    public FruitsRecyclerViewAdapter(Context context) {
        this.context = context;
        utils = new Util();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_fruit_recycler_view, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtFruitTitle.setText(fruits.get(position).getTitle());
        holder.txtFruitHeadline.setText(fruits.get(position).getHeadline());

        ArrayList<String> gradiantColor = fruits.get(position).getGradientColors();

//        int[] colors = {Color.parseColor("#008000"),Color.parseColor("#ADFF2F")};
        int[] colors = {Color.parseColor(gradiantColor.get(0)),Color.parseColor(gradiantColor.get(1))};

//create a new gradient color
        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM, colors);
        gd.setCornerRadius(0f);
//        holder.itemView.setBackground(gd);

        holder.fruitImage.setBackground(gd);

        holder.fruitCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FruitActivity.class);
                intent.putExtra("fruitId", fruits.get(position).getId());
                context.startActivity(intent);
            }
        });

        Log.d(TAG, "onBindViewHolder: started " + fruits.get(position).getImage());

        Glide.with(context)
                .asBitmap()
                .load(getImage(fruits.get(position).getImage()))
                .into(holder.fruitImage);
    }

    public int getImage(String imageName) {
        Log.d(TAG, "getImage: " + imageName);
        int drawableResourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        return drawableResourceId;
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }


    public class  ViewHolder extends RecyclerView.ViewHolder {
        private CardView fruitCard;
        private ImageView fruitImage;
        private TextView txtFruitTitle;
        private TextView txtFruitHeadline;

        public ViewHolder(View itemVIew) {
            super(itemVIew);

            fruitCard = (CardView) itemVIew.findViewById(R.id.fruitCard); 
            fruitImage = (ImageView) itemVIew.findViewById(R.id.ivFruitImage);
            txtFruitTitle = (TextView) itemVIew.findViewById(R.id.tvFruitTitle);
            txtFruitHeadline = (TextView) itemVIew.findViewById(R.id.tvFruitHeadline);
        }
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
        notifyDataSetChanged();
    }
}
