package com.example.islandbuilder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StructureAdapter extends RecyclerView.Adapter<StructureVH> {
    List<Structure> structureList;
//    Context context;
//    private SelectListener listener;

    public StructureAdapter(List<Structure> structureList) {
        this.structureList = structureList;

    }

    @NonNull
    @Override
    public StructureVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_selection, parent, false);
        StructureVH structureVHolder = new StructureVH(view);
        return structureVHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StructureVH holder, int position) {
    Structure structure = structureList.get(position);
    holder.structureImage.setImageResource(structure.getDrawableId());
    holder.structureText.setText(structure.getLabel());
    }

    @Override
    public int getItemCount() {
        return structureList.size();
    }
}
