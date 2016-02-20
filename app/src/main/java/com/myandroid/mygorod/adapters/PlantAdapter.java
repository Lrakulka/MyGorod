package com.myandroid.mygorod.adapters;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myandroid.mygorod.R;
import com.myandroid.mygorod.entities.Element;

import java.util.ArrayList;

public class PlantAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private ArrayList data = new ArrayList();

    public PlantAdapter(Context context, int resource, ArrayList objects) {
        super(context, resource,objects);
        this.layoutResourceId = resource;
        this.context = context;
        this.data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.nameElement= (TextView) row.findViewById(R.id.textView_namePlant);
            holder.pictureElement = (ImageView) row.findViewById(R.id.imageViewPlant);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        Element item = (Element) data.get(position);
        holder.idElement = item.getIdElement();
        holder.nameElement.setText(item.getName());
        holder.pictureElement.setImageResource(R.drawable.carrot);
        return row;
    }
    static class ViewHolder {
        int idElement;
        TextView nameElement;
        ImageView pictureElement;
    }
}
