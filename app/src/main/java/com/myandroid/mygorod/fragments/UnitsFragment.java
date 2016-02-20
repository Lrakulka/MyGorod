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

        Intent intent = getActivity().getIntent();
        if (intent != null) {
            ogorofMap = (OgorodItem) intent.getSerializableExtra(getString(R.string.ogorod_key));
        }
        Log.v(LOG_TAG,"idOgorod = " + ogorofMap);
        View rootView = inflater.inflate(R.layout.fragment_units, container,false);


        TextView textIdOgorod = (TextView) rootView.findViewById(R.id.textView);
        Button button1 = (Button) rootView.findViewById(R.id.button1);
        Button button3 = (Button) rootView.findViewById(R.id.button3);
        final Button button2 = (Button) rootView.findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setX(button2.getX() + 10);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setX(button2.getX() - 10);
            }
        });
        String textForSasha = "idOgorod = " + String.valueOf(ogorofMap);

        textIdOgorod.setText(textForSasha.toString());
        return rootView;
    }

}
