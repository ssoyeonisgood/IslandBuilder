package com.example.islandbuilder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MapFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter mapAdapter;
    MapElement[][] grid;
    MapData mapData;
    SelectorFragment selectorFragment;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mapData = mapData.get();
        grid = mapData.getGrid();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_map,container,false);
        recyclerView = rootView.findViewById(R.id.mapRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), MapData.HEIGHT, GridLayoutManager.HORIZONTAL, false));
        mapAdapter = new MapAdapter(grid);
        recyclerView.setAdapter(mapAdapter);

        return rootView;
    }

    public void setSelectorFragment(SelectorFragment selectorFragment) {
        this.selectorFragment = selectorFragment;
    }
}