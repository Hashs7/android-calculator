package com.gmail.pro.glagouy.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.pro.glagouy.example.R;

import androidx.annotation.NonNull;

public class MyAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public MyAdapter(Context context, String[] values) {
        super(context, R.layout.line_item, R.id.tv_planete, values);
        this.context = context;
        this.values  = values;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.line_item, parent, false);
        TextView textView = rowView.findViewById(R.id.tv_planete);
        ImageView imageView = rowView.findViewById(R.id.iv_planete);
        textView.setText(values[position]);
        imageView.setImageResource(R.drawable.ic_launcher_background);

        return rowView;
    }
}
