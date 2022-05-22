package com.example.insorma;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FurnitureAdapter extends ArrayAdapter{
    ArrayList <FurniturePlaceholder> furniturePlaceholders = new ArrayList<>();

    public FurnitureAdapter(Activity activity, int resource, ArrayList<FurniturePlaceholder>objects){
        super(activity, resource, objects);
        furniturePlaceholders = objects;

    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        LayoutInflater LIF = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = LIF.inflate(R.layout.main_page_list,null);

        ImageView Picture = view.findViewById(R.id.ProductPic);
        TextView Name = view.findViewById(R.id.furnitureName);
        TextView Price = view.findViewById(R.id.furniturePrice);
        TextView Rating = view.findViewById(R.id.furnitureRating);

        Picture.setImageResource(furniturePlaceholders.get(position).getFurnitureImage());
        Name.setText(furniturePlaceholders.get(position).getFurnitureName());
        Price.setText(furniturePlaceholders.get(position).getFurniturePrice());
        Rating.setText(furniturePlaceholders.get(position).getFurnitureRating());

        return view;
    }


}
