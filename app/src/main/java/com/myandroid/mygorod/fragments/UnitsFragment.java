package com.myandroid.mygorod.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.myandroid.mygorod.entities.Garden;
import com.myandroid.mygorod.R;
import com.myandroid.mygorod.entities.Unit;

import java.util.ArrayList;
import java.util.List;

public class UnitsFragment extends Fragment {

    private final String LOG_TAG = UnitsFragment.class.getSimpleName();
    private ArrayList<Unit> units;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView;
        AbsoluteLayout mapContainer;
        LinearLayout layoutMapUnit;
        LinearLayout.LayoutParams layoutUnitParams;
        BitmapDrawable unitBackground;

        Intent intent = getActivity().getIntent();
        if (intent != null) {
            units = (ArrayList<Unit>) intent.getSerializableExtra(getString(R.string.ogorod_key));
            rootView = inflater.inflate(R.layout.fragment_units, container,false);
            mapContainer = (AbsoluteLayout) rootView.findViewById(R.id.mapcontainer);
            for (Unit unit : units) {
                layoutMapUnit = new LinearLayout(getContext());
                layoutMapUnit.setX(unit.getX());
                layoutMapUnit.setY(unit.getY());
                layoutUnitParams = new LinearLayout.LayoutParams( unit.getWeight(), unit.getHeight());

                //Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.gorods);
                Bitmap image = unit.getElement().getImage();
                Bitmap newBitmap = Bitmap.createBitmap(image.getWidth(), image.getHeight(), image.getConfig());
                Canvas canvas = new Canvas(newBitmap);
                canvas.drawColor(unit.getElement().getColor());
                canvas.drawBitmap(image, 0, 0, null);
                unitBackground = new BitmapDrawable(newBitmap);

                //unitBackground = new BitmapDrawable(unit.getElement().getImage());
                unitBackground.setTileModeX(Shader.TileMode.REPEAT);
                unitBackground.setTileModeY(Shader.TileMode.REPEAT);
                layoutMapUnit.setBackgroundDrawable(unitBackground);
                mapContainer.addView(layoutMapUnit, layoutUnitParams);
            }
        } else {
            rootView = inflater.inflate(R.layout.error, container, false);
        }
        return rootView;
    }
}
