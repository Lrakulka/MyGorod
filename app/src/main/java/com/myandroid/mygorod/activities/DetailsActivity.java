package com.myandroid.mygorod.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.myandroid.mygorod.R;
import com.myandroid.mygorod.fragments.PlantDetailFragment;

public class DetailsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_details);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.containerForDetails, new PlantDetailFragment())
                    .commit();
        }
    }
}
