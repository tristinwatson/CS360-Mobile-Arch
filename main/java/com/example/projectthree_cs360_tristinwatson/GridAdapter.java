package com.example.projectthree_cs360_tristinwatson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    // variables
    Context context;
    String[] flowerName;
    int[] image;

    LayoutInflater inflater;

    // constructor
    public GridAdapter(Context context, String[] flowerName, int[] image) {
        this.context = context;
        this.flowerName = flowerName;
        this.image = image;
    }

    // getters
    @Override
    public int getCount() {
        return flowerName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_item, null);
        }

        // sets variables for convertView
        ImageView imageView = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.item_name);

        imageView.setImageResource(image[position]);
        textView.setText(flowerName[position]);

        return convertView;
    }
}
