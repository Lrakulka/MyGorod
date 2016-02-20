package com.myandroid.mygorod.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.myandroid.mygorod.R;
import com.myandroid.mygorod.activities.UnitsActivity;
import com.myandroid.mygorod.adapters.OgorodAdapter;
import com.myandroid.mygorod.adapters.PlantAdapter;
import com.myandroid.mygorod.entities.Element;

import java.util.ArrayList;

public class PlantsFragment extends Fragment {

    ListView listPlantsOnYourOgorod;
    PlantAdapter adapter;

    ArrayList<Element> elements;

    public PlantsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_plants, container, false);

        getPlants();
        showPlants(rootView);

//        listPlantsOnYourOgorod.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getActivity(), UnitsActivity.class);
//
//                intent.putExtra(getString(R.string.ogorod_key), elements.get(position));
//                startActivity(intent);
//            }
//        });

        return rootView;
    }

    private void getPlants() {
        elements = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            elements.add(new Element("Рослина №"+(i+1), BitmapFactory.decodeResource(getResources(), R.drawable.carrot), String.valueOf(Color.CYAN), "description"));
        }
    }

    private void showPlants(View rootView) {
        listPlantsOnYourOgorod = (ListView) rootView.findViewById(R.id.listView_plants);
        adapter = new PlantAdapter(getActivity(), R.layout.item_plant, elements);
        listPlantsOnYourOgorod.setAdapter(adapter);
    }
}
