package com.myandroid.mygorod;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class UnitsFragment extends Fragment {

    private final String LOG_TAG = UnitsFragment.class.getSimpleName();

    private OgorodItem ogorofMap;
    public UnitsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Intent intent = getActivity().getIntent();
        if (intent != null) {
            ogorofMap = (OgorodItem) intent.getSerializableExtra(getString(R.string.ogorod_key));
        }
        Log.v(LOG_TAG,"idOgorod = " + ogorofMap);
        View rootView = inflater.inflate(R.layout.fragment_units, container,false);

        TextView textIdOgorod = (TextView)rootView.findViewById(R.id.textView);

        String textForSasha = "idOgorod = " + String.valueOf(ogorofMap.getIdOgorod()+1);
        textIdOgorod.setText(textForSasha.toString());
        return rootView;
    }

}
