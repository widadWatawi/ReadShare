package com.example.readshare.Activity.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.Model.Demande;
import com.example.readshare.Model.Historique;
import com.example.readshare.R;

import java.util.List;

public class HistoriqueAdapter extends BaseAdapter {
    Context context;
    private List<Historique> liste;
    View view;

    public HistoriqueAdapter(Context context,List<Historique> liste) {
        this.context=context;
        this.liste = liste;
    }

    @Override
    public int getCount() {
        return liste.size();
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
            TextView textView=view.findViewById(R.id.titre);
            //imageView.setImageResource(images[position]);
            textView.setText(liste.get(position).getLivre().getTitre());
        }
        return view;
    }
}

