package com.example.islandbuilder;

import static android.view.DragEvent.ACTION_DROP;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MapAdapter extends RecyclerView.Adapter<MapVH> {

    SelectorFragment selectorFragment;

    public MapAdapter(){
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
        MapElement[][] grid = MapData.get().getGrid();
        MapElement mapElement = grid[row][col];
        holder.image1.setImageResource(mapElement.getNorthWest());
        holder.image2.setImageResource(mapElement.getNorthEast());
        holder.image3.setImageResource(mapElement.getSouthWest());
        holder.image4.setImageResource(mapElement.getSouthEast());

        if (mapElement.getStructure() != null) {
            holder.image5.setImageResource(mapElement.getStructure().getDrawableId());
        }

        holder.image5.setOnClickListener(v -> {
            if(mapElement.getStructure() != null) {
                mapElement.setStructure(null);
                notifyItemChanged(position);
            }else {
                mapElement.setStructure(selectorFragment.getSelectedStructure());
                notifyItemChanged(position);
            }

        });

        holder.image5.setOnDragListener((v, e ) -> {
            switch(e.getAction()) {
                case ACTION_DROP:
                    Structure selectedStructure = (Structure) e.getLocalState();
                    if (mapElement.isBuildable()) {
                        mapElement.setStructure(selectedStructure);
                        notifyItemChanged(position);
                    }
                    return true;
            }
            return true;
        });


    }

    @Override
    public int getItemCount() {
        return MapData.HEIGHT*MapData.WIDTH;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
