package com.example.islandbuilder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SelectorFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter structureAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Structure> structureList;
    StructureData structureData;
    Structure selectedStructure;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        structureData = structureData.get();
        structureList = structureData.getStructureList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_selector,container,false);
       recyclerView = rootView.findViewById(R.id.selectorRecyclerView);
       recyclerView.setHasFixedSize(true);
       layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
       recyclerView.setLayoutManager(layoutManager);
       structureAdapter = new StructureAdapter(structureList);
       recyclerView.setAdapter(structureAdapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        return rootView;
    }
    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper
            .SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END, 0 ) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            int fromPosition = viewHolder.getBindingAdapterPosition();
            int toPosition = target.getBindingAdapterPosition();
            Collections.swap(structureList,fromPosition,toPosition);
            recyclerView.getAdapter().notifyItemMoved(fromPosition, toPosition);
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }
    };

    public Structure getSelectedStructure() {
        return selectedStructure;
    }

    public void setSelectedStructure(Structure selectedStructure) {
        this.selectedStructure = selectedStructure;
    }
}
