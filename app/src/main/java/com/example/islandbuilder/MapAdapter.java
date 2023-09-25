package com.example.islandbuilder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MapAdapter extends RecyclerView.Adapter<MapVH> {
    MapElement[][] grid;

    public MapAdapter(MapElement[][] grid){
        this.grid = grid;
    }
    @NonNull
    @Override
    public MapVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.grid_cell,parent,false);
        MapVH mapVHolder = new MapVH(view,parent);
        return mapVHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MapVH holder, int position) {
        int row = position % MapData.HEIGHT;
        int col = position / MapData.HEIGHT;
        MapElement mapElement = grid[row][col];
        holder.image1.setImageResource(mapElement.getNorthWest());
        holder.image2.setImageResource(mapElement.getNorthEast());
        holder.image3.setImageResource(mapElement.getSouthWest());
        holder.image4.setImageResource(mapElement.getSouthEast());

        if (mapElement.getStructure() != null) {
            holder.image5.setImageResource(mapElement.getStructure().getDrawableId());
        }
    }

    @Override
    public int getItemCount() {
        return grid.length;
    }
}
