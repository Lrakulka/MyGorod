package com.myandroid.mygorod.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.TextView;
import android.widget.Toast;

import com.myandroid.mygorod.activities.DetailsActivity;
import com.myandroid.mygorod.entities.Garden;
import com.myandroid.mygorod.R;
import com.myandroid.mygorod.entities.Unit;

import java.util.ArrayList;
import java.util.List;

public class UnitsFragment extends Fragment {

    private static final Integer TEXT_SIZE = 20;
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
        TextView textView;

        final Intent intent = getActivity().getIntent();
        if (intent != null) {
            units = (ArrayList<Unit>) intent.getSerializableExtra(getString(R.string.ogorod_key));
            rootView = inflater.inflate(R.layout.fragment_units, container,false);
            mapContainer = (AbsoluteLayout) rootView.findViewById(R.id.mapcontainer);
            for (final Unit unit : units) {
                layoutMapUnit = new LinearLayout(getContext());
                layoutMapUnit.setX(unit.getX());
                layoutMapUnit.setY(unit.getY());
                layoutUnitParams = new LinearLayout.LayoutParams( unit.getWeight(), unit.getHeight());

                Bitmap image = unit.getElement().getImage();
                Bitmap newBitmap = Bitmap.createBitmap(image.getWidth(), image.getHeight(), image.getConfig());
                Canvas canvas = new Canvas(newBitmap);
                canvas.drawColor(unit.getElement().getColor());
                canvas.drawBitmap(image, 0, 0, null);
                unitBackground = new BitmapDrawable(newBitmap);
                unitBackground.setTileModeX(Shader.TileMode.REPEAT);
                unitBackground.setTileModeY(Shader.TileMode.REPEAT);
                //-----
                unit.getElement().setImage(newBitmap);
                //-----
                layoutMapUnit.setBackgroundDrawable(unitBackground);
                //--
                layoutMapUnit.setOnClickListener(new View.OnClickListener() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    final String[] mCatsName ={"Інформація", "Завдання"};

                    @Override
                    public void onClick(View v) {
                        builder.setTitle("Виберіть дію"); // заголовок для диалога
                        builder.setIcon(R.drawable.paper);
                        builder.setCancelable(true);
                        builder.setItems(mCatsName, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int item) {
                                switch (item) {
                                    case 0: {
                                        Intent intent1 = new Intent(getActivity(), DetailsActivity.class);
                                        intent1.putExtra(getResources().getString(R.string.info_key), unit.getElement());
                                        startActivity(intent1);
                                        break;
                                    }
                                    case 1: {

                                        break;
                                    }
                                }
                            }
                        });
                        builder.setCancelable(false);
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                });
                        //---
                if (unit.getTasks() != null && unit.getTasks().size() > 0) {
                    textView = new TextView(getContext());
                    textView.setTextSize(TEXT_SIZE);
                    textView.setBackgroundColor(Color.WHITE);
                    textView.setText(String.valueOf(unit.getTasks().size()));
                    layoutMapUnit.addView(textView);
                }
                mapContainer.addView(layoutMapUnit, layoutUnitParams);
            }
        } else {
            rootView = inflater.inflate(R.layout.error, container, false);
        }
        return rootView;
    }
}
