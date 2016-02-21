package com.myandroid.mygorod.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.myandroid.mygorod.R;
import com.myandroid.mygorod.adapters.BoxAdapter;
import com.myandroid.mygorod.entities.Task;
import com.myandroid.mygorod.entities.Unit;
import com.myandroid.mygorod.entities.Worker;

public class TaskActivity extends AppCompatActivity {

    ArrayList<Task> tasks = new ArrayList<Task>();
    BoxAdapter boxAdapter;
    Worker worker;
    Unit unit;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        // создаем адаптер
        fillData();
        boxAdapter = new BoxAdapter(this, tasks);

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(boxAdapter);
    }

    // генерируем данные для адаптера
    void fillData() {
        final Intent intent = getIntent();
        if (intent != null) {
            worker = (Worker) intent.getSerializableExtra(getResources().getString(R.string.info_garden));
            unit = (Unit) intent.getSerializableExtra(getResources().getString(R.string.item_key));
            tasks = unit.getTasks();
        }
    }

}