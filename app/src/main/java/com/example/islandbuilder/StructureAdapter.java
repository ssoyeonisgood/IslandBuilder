package com.example.islandbuilder;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StructureAdapter extends RecyclerView.Adapter<StructureVH> {
    List<Structure> structureList;
    SelectorFragment selectorFragment;
    private SelectListener listener;
    private int selectedPos;

    public StructureAdapter(List<Structure> structureList, SelectListener listener ) {
        this.structureList = structureList;
        this.listener = listener;
        this.selectedPos = RecyclerView.NO_POSITION;
    }

    public void setSelectedPos(int position) {
        this.selectedPos = position;
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
    holder.structureImage.setOnLongClickListener(v -> {
            ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
            ClipData dragData = new ClipData(
                    (CharSequence) v.getTag(),
                    new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN },
                    item);

            View.DragShadowBuilder myShadow = new View.DragShadowBuilder(v);
            v.startDragAndDrop(dragData, myShadow, structure, 0);
            return true;
        });

    holder.structureImage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (holder.getAdapterPosition() == RecyclerView.NO_POSITION) return;
            listener.onItemClicked(structureList.get(holder.getLayoutPosition()));
            notifyItemChanged(selectedPos);
            selectedPos = holder.getAdapterPosition();
            notifyItemChanged(selectedPos);
        }
    });


    }

    @Override
    public int getItemCount() {
        return structureList.size();
    }

}
