package com.myandroid.mygorod.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.myandroid.mygorod.entities.OgorodItem;
import com.myandroid.mygorod.R;

public class UnitsFragment extends Fragment {

    private final String LOG_TAG = UnitsFragment.class.getSimpleName();

    private OgorodItem ogorofMap;
    public UnitsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            ogorofMap = (OgorodItem) intent.getSerializableExtra(getString(R.string.ogorod_key));
            rootView = inflater.inflate(R.layout.fragment_units, container,false);
        } else {
            rootView = inflater.inflate(R.layout.error, container,false);
        }

        return rootView;
    }

}
