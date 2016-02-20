package com.myandroid.mygorod.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myandroid.mygorod.entities.Garden;
import com.myandroid.mygorod.R;

public class UnitsFragment extends Fragment {

    private final String LOG_TAG = UnitsFragment.class.getSimpleName();

    private Garden garden;
    public UnitsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            garden = (Garden) intent.getSerializableExtra(getString(R.string.ogorod_key));
            rootView = inflater.inflate(R.layout.fragment_units, container,false);
            //garden.get
        } else {
            rootView = inflater.inflate(R.layout.error, container,false);
        }
        return rootView;
    }
}
