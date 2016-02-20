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
import com.myandroid.mygorod.entities.Garden;

import java.util.ArrayList;

public class OgorodAdapter extends ArrayAdapter {

    private Context context;
    private int layoutResourceId;
    private ArrayList data = new ArrayList();

    public OgorodAdapter(Context context, int resource, ArrayList objects) {
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
            holder.nameOgorod= (TextView) row.findViewById(R.id.textView_nameOgorod);
            holder.pictureOgorod = (ImageView) row.findViewById(R.id.imageViewOgorod);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        Garden item = (Garden) data.get(position);
        holder.nameOgorod.setText(item.getName());
        holder.pictureOgorod.setImageResource(R.drawable.chevron_right);
        return row;
    }
    static class ViewHolder {
        int idOgorod;
        TextView nameOgorod;
        ImageView pictureOgorod;
    }
}
