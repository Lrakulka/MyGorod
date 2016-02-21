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
                tasks.add(new Task(new Date(), "Полити", "kartoha1"));
                tasks.add(new Task(new Date(), "Підрізати", "kartoha2"));
                tasks.add(new Task(new Date(), "Здобрити", "kartoha3"));
                gardens = new ArrayList<Garden>();
                Garden garden1 = new Garden("Город1", new Boss(), 0, 0, new ArrayList<Unit>());
                ArrayList<Unit> garden1Unit1 = new ArrayList<Unit>();
                garden1Unit1.add(new Unit(0, 0, 200, 300, new Element("Картопля", BitmapFactory.decodeResource(getResources(), R.drawable.potatoes), String.valueOf(Color.CYAN), "Берегти від колорадів"), tasks));
                garden1Unit1.add(new Unit(200, 0, 100, 400, new Element("Помідори", BitmapFactory.decodeResource(getResources(), R.drawable.tomato), String.valueOf(Color.YELLOW), "Фітофтра наш ворог"), null));
                garden1Unit1.add(new Unit(0, 300, 200, 100, new Element("Огірки", BitmapFactory.decodeResource(getResources(), R.drawable.cucumber), String.valueOf(Color.RED), "Будуть гіркими, якщо не поливати"), tasks));
                garden1.setUnits(garden1Unit1);
                gardens.add(garden1);

                Garden garden2 = new Garden("Город2", new Boss(), 0, 0, new ArrayList<Unit>());
                ArrayList<Unit> garden1Unit2 = new ArrayList<Unit>();
                garden1Unit2.add(new Unit(0, 0, 200, 300, new Element("Картопля", BitmapFactory.decodeResource(getResources(), R.drawable.potatoes), String.valueOf(Color.BLUE), "Якась інформація"), tasks));
                garden1Unit2.add(new Unit(200, 0, 100, 400, new Element("Помідори", BitmapFactory.decodeResource(getResources(), R.drawable.tomato), String.valueOf(Color.GREEN), "Дані"), null));
                ArrayList<Task> tasks2 = new ArrayList<Task>(tasks);
                tasks2.add(new Task(new Date(), "Зірвати", "kartoha3"));
                garden1Unit2.add(new Unit(0, 300, 200, 100, new Element("Огірки", BitmapFactory.decodeResource(getResources(), R.drawable.cucumber), String.valueOf(Color.CYAN), "Якісь дані"), tasks2));
                garden1Unit2.add(new Unit(0, 400, 300, 100, new Element("Морква", BitmapFactory.decodeResource(getResources(), R.drawable.carrot2), String.valueOf(Color.RED), "Якісь дані..."), tasks2));
                garden2.setUnits(garden1Unit2);
                gardens.add(garden2);

                Garden garden3 = new Garden("Город2", new Boss(), 0, 0, new ArrayList<Unit>());
                ArrayList<Unit> garden1Unit3 = new ArrayList<Unit>();
                garden1Unit3.add(new Unit(0, 0, 200, 300, new Element("Картопля", BitmapFactory.decodeResource(getResources(), R.drawable.potatoes), String.valueOf(Color.CYAN), "Якась інформація"), tasks2));
                garden1Unit3.add(new Unit(200, 0, 100, 400, new Element("Помідори", BitmapFactory.decodeResource(getResources(), R.drawable.tomato), String.valueOf(Color.YELLOW), "Дані"), null));
                ArrayList<Task> tasks3 = new ArrayList<Task>(tasks2);
                tasks3.add(new Task(new Date(), "Зірвати, полити", "kartoha3"));
                garden1Unit3.add(new Unit(0, 300, 200, 100, new Element("Огірки", BitmapFactory.decodeResource(getResources(), R.drawable.cucumber), String.valueOf(Color.RED), "Якісь дані"), tasks3));
                garden3.setUnits(garden1Unit3);
                gardens.add(garden3);

                if (worker == null) {
                    worker = new Worker("133", gardens.get(position));
                } else {
                    worker.setGarden(gardens.get(position));
                }
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
