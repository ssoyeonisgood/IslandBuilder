package com.example.islandbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MapFragment mapFragment = new MapFragment();
    SelectorFragment selectorFragment = new SelectorFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragManager = getSupportFragmentManager();
        fragManager.beginTransaction().replace(R.id.mapFrag, mapFragment).commit();
        fragManager.beginTransaction().replace(R.id.selectorFrag, selectorFragment).commit();

        mapFragment.setSelectorFragment(selectorFragment);



    }
}