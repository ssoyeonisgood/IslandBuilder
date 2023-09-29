package com.example.islandbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    MapFragment mapFragment = new MapFragment();
    SelectorFragment selectorFragment = new SelectorFragment();

    MapData mapData;

    Button regenerateButton;

    MapAdapter mapAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapData = MapData.get();

        regenerateButton = findViewById(R.id.regenerateButton);
        FragmentManager fragManager = getSupportFragmentManager();
        fragManager.beginTransaction().replace(R.id.mapFrag, mapFragment).commit();
        fragManager.beginTransaction().replace(R.id.selectorFrag, selectorFragment).commit();

        mapFragment.setSelectorFragment(selectorFragment);

        regenerateButton.setOnClickListener(v -> {
            mapData.regenerate();
            mapAdapter = (MapAdapter) mapFragment.getMapAdapter();
            mapAdapter.notifyItemRangeChanged(0, MapData.WIDTH * MapData.HEIGHT);
        });





    }
}