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

        return rootView;
    }




    public Structure getSelectedStructure() {
        return selectedStructure;
    }

    public void setSelectedStructure(Structure selectedStructure) {
        this.selectedStructure = selectedStructure;
    }
}
