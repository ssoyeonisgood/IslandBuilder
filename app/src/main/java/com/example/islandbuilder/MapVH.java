package com.example.islandbuilder;

import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MapVH extends RecyclerView.ViewHolder {

    public ImageView image1;
    public ImageView image2;
    public ImageView image3;
    public ImageView image4;
    public ImageView image5;
    public MapVH(@NonNull View itemView, ViewGroup parent) {
        super(itemView);
        int size = parent.getMeasuredHeight() / MapData.HEIGHT + 1;
        ViewGroup.LayoutParams lp = itemView.getLayoutParams();
        lp.width = size;
        lp.height = size;

        image1 = itemView.findViewById(R.id.image1);
        image2 = itemView.findViewById(R.id.image2);
        image3 = itemView.findViewById(R.id.image3);
        image4 = itemView.findViewById(R.id.image4);
        image5 = itemView.findViewById(R.id.image5);
    }

}
