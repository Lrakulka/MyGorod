package com.myandroid.mygorod.fragments;

import android.content.Intent;
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
import android.widget.Toast;

import com.myandroid.mygorod.adapters.OgorodAdapter;
import com.myandroid.mygorod.R;
import com.myandroid.mygorod.activities.UnitsActivity;
import com.myandroid.mygorod.entities.Boss;
import com.myandroid.mygorod.entities.Element;
import com.myandroid.mygorod.entities.Garden;
import com.myandroid.mygorod.entities.Task;
import com.myandroid.mygorod.entities.Unit;
import com.myandroid.mygorod.entities.Worker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class OgorodFragment extends Fragment implements Serializable {
    ListView listOgorods;
    OgorodAdapter adapter;
    Worker worker;
    ArrayList<Garden> gardens;

    public OgorodFragment() {}

    public OgorodFragment(Worker worker) {
        this.worker = worker;
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

                //--
                final ArrayList<Task> tasks = new ArrayList<Task>();
                tasks.add(new Task(new Date(), "Part1", "kartoha1"));
                tasks.add(new Task(new Date(), "Part2", "kartoha2"));
                tasks.add(new Task(new Date(), "Part3", "kartoha3"));
                gardens = new ArrayList<Garden>();
                gardens.add(new Garden("Ogorod1", new Boss(), 0, 0, new ArrayList<Unit>()));
                gardens.get(0).getUnits().add(new Unit(0, 0, 200, 300, new Element("Pat1", BitmapFactory.decodeResource(getResources(), R.drawable.chevron_right), String.valueOf(Color.CYAN), "p1"), tasks));
                gardens.get(0).getUnits().add(new Unit(200, 0, 100, 400, new Element("Pat2", BitmapFactory.decodeResource(getResources(), R.drawable.gorods), String.valueOf(Color.YELLOW), "p2"), null));
                gardens.get(0).getUnits().add(new Unit(0, 300, 200, 100, new Element("Pat3", BitmapFactory.decodeResource(getResources(), R.drawable.chevron_right), String.valueOf(Color.RED), "p3"), tasks));

                //---
                ArrayList<Unit> units = (ArrayList<Unit>) gardens.get(0).getUnits();
                Toast.makeText(getContext(), worker.getId(), Toast.LENGTH_LONG).show();
                Worker worker = new Worker("142", gardens.get(0));
                intent.putExtra(getString(R.string.ogorod_key), worker);
                startActivity(intent);
            }
        });

        return rootView;
    }

    private void getOgorods() {
        gardens = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            gardens.add(new Garden("Город №" + (i + 1), new Boss(), 0, 0, new ArrayList<Unit>()));
        }
    }

    private void showOgorods(View rootView) {
        listOgorods = (ListView) rootView.findViewById(R.id.listView_ogorods);
        adapter = new OgorodAdapter(getActivity(), R.layout.item_gorod, gardens);
        listOgorods.setAdapter(adapter);
    }
}
