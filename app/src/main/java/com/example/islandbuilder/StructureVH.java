package com.example.islandbuilder;

import android.content.ClipData;
import android.content.ClipDescription;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class StructureVH extends RecyclerView.ViewHolder {

    public ImageView structureImage;
    public TextView structureText;
    public CardView cardView;

    public StructureVH(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.cardView);
        structureImage = itemView.findViewById(R.id.structureImage);
        structureText = itemView.findViewById(R.id.structureText);
    }
}
