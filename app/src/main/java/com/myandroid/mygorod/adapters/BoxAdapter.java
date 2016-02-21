package com.myandroid.mygorod.adapters;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.myandroid.mygorod.R;
import com.myandroid.mygorod.entities.Task;

public class BoxAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Task> objects;

    public BoxAdapter(Context context, ArrayList<Task> tasks) {
        ctx = context;
        objects = tasks;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        Task p = getProduct(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.tvDescr)).setText(p.getName());
        ((TextView) view.findViewById(R.id.tvPrice)).setText(p.getDate_time().toString());
        /*((ImageView) view.findViewById(R.id.ivImage)).setImageResource(p.get);*/

        CheckBox cbBuy = (CheckBox) view.findViewById(R.id.cbBox);
        // присваиваем чекбоксу обработчик
        cbBuy.setOnCheckedChangeListener(myCheckChangList);
        // пишем позицию
        cbBuy.setTag(position);
        // заполняем данными из товаров: в корзине или нет
       // cbBuy.setChecked(p.box);
        return view;
    }

    // товар по позиции
    Task getProduct(int position) {
        return ((Task) getItem(position));
    }

    // содержимое корзины
    ArrayList<Task> getBox() {
        ArrayList<Task> box = new ArrayList<Task>();
        for (Task p : objects) {
            // если в корзине
        }
        return box;
    }

    // обработчик для чекбоксов
    OnCheckedChangeListener myCheckChangList = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            // меняем данные товара (в корзине или нет)
            //getProduct((Integer) buttonView.getTag()). = isChecked;
           // Toast.makeText(this, "Зроблено", Toast.LENGTH_SHORT).show();
        }
    };
}
