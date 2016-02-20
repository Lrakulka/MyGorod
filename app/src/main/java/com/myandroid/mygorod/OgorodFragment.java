package com.myandroid.mygorod;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class OgorodFragment extends Fragment {

    ListView listOgorods;
    OgorodAdapter adapter;

    ArrayList<OgorodItem> ogorods;

    public OgorodFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ogorod, container, false);

        getOgorods();
        showOgorods(rootView);

        return rootView;
    }

    private void getOgorods() {
        ogorods = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ogorods.add(new OgorodItem(i,"Ogorod "+i,"picture"));
        }
    }

    private void showOgorods(View rootView) {
        listOgorods = (ListView) rootView.findViewById(R.id.listView_ogorods);
        adapter = new OgorodAdapter(getActivity(), R.layout.item_gorod, ogorods);
        listOgorods.setAdapter(adapter);
    }
}
