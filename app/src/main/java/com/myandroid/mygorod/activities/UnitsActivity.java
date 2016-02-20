package com.myandroid.mygorod.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.myandroid.mygorod.R;
import com.myandroid.mygorod.fragments.UnitsFragment;

public class UnitsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_units);
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.containerForUnits, new UnitsFragment());//units fragment
            transaction.commit();
        }
    }
}
