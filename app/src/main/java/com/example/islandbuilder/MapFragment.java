package com.example.islandbuilder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

public class MapFragment extends Fragment implements SelectListener2{
    RecyclerView recyclerView;
    RecyclerView.Adapter mapAdapter;
    MapData mapData;
    SelectorFragment selectorFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mapData = mapData.get();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_map,container,false);
        recyclerView = rootView.findViewById(R.id.mapRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), MapData.HEIGHT, GridLayoutManager.HORIZONTAL, false));
        mapAdapter = new MapAdapter(this);
        recyclerView.setAdapter(mapAdapter);
        return rootView;
    }

    public void setSelectorFragment(SelectorFragment selectorFragment) {
        this.selectorFragment = selectorFragment;
    }

    public RecyclerView.Adapter getMapAdapter() {
        return mapAdapter;
    }

    @Override
    public void onItemClicked(MapElement mapElement) {
        if (mapElement.isBuildable()){
            mapElement.setStructure(selectorFragment.getSelectedStructure());
        }
    }
}