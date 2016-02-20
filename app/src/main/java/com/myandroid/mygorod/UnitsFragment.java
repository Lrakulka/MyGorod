package com.myandroid.mygorod;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UnitsFragment extends Fragment {

    private final String LOG_TAG = UnitsFragment.class.getSimpleName();

    private int idOgorod;
    public UnitsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Intent intent = getActivity().getIntent();
        if (intent != null) {
            idOgorod = intent.getIntExtra("idOgorod", 0);
        }
        Log.v(LOG_TAG,"idOgorod = " + idOgorod);
        View rootView = inflater.inflate(R.layout.fragment_units, container,false);

        TextView textIdOgorod = (TextView)rootView.findViewById(R.id.textView);
        String textForSasha = "idOgorod = " + String.valueOf(idOgorod);
        textIdOgorod.setText(textForSasha.toString());
        return rootView;
    }

}
