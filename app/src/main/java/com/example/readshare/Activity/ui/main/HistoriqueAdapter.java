package com.example.readshare.Activity.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.R;

public class HistoriqueAdapter extends BaseAdapter {
    Context context;
    private final String[] values;
    private  final int[] images;
    View view;

    public HistoriqueAdapter(Context context, String[] values,int[] images) {
        this.context=context;
        this.values=values;
        this.images=images;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView==null){
            view=new View(context);
            view=layoutInflater.inflate(R.layout.list_historique,null);
            ImageView imageView=view.findViewById(R.id.livrelu);
            TextView textView=view.findViewById(R.id.titleBook);
            imageView.setImageResource(images[position]);
            textView.setText(values[position]);
        }
        return view;
    }
}

