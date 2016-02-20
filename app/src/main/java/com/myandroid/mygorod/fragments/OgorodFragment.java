package com.myandroid.mygorod.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.myandroid.mygorod.adapters.OgorodAdapter;
import com.myandroid.mygorod.R;
import com.myandroid.mygorod.activities.UnitsActivity;
import com.myandroid.mygorod.entities.Boss;
import com.myandroid.mygorod.entities.Garden;
import com.myandroid.mygorod.entities.Unit;

import java.util.ArrayList;

public class OgorodFragment extends Fragment {
    ListView listOgorods;
    OgorodAdapter adapter;

    ArrayList<Garden> ogorods;

    public OgorodFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ogorod, container, false);

        getOgorods();
        showOgorods(rootView);

        listOgorods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), UnitsActivity.class);

                intent.putExtra(getString(R.string.ogorod_key), ogorods.get(position));
                startActivity(intent);
            }
        });

        return rootView;
    }

    private void getOgorods() {
        ogorods = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ogorods.add(new Garden("Город №"+(i+1), new Boss(), 0, 0, new ArrayList<Unit>()));
        }
    }

    private void showOgorods(View rootView) {
        listOgorods = (ListView) rootView.findViewById(R.id.listView_ogorods);
        adapter = new OgorodAdapter(getActivity(), R.layout.item_gorod, ogorods);
        listOgorods.setAdapter(adapter);
    }
}
