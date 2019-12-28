package com.example.readshare.Activity.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.R;

public class TracabiliteAdapter extends RecyclerView.Adapter<TracabiliteAdapter.ViewHolder>{
private ListTracabilite[] listTracabilite;

// RecyclerView recyclerView;
public TracabiliteAdapter(ListTracabilite[] listTracabilites) {
        this.listTracabilite=listTracabilites;
        }
@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.liste_tracabilite, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
        }


@Override
public void onBindViewHolder(ViewHolder holder, int position) {
final ListTracabilite myList = listTracabilite[position];
        holder.distuser.setText(listTracabilite[position].getDistance());
        holder.imageuser.setImageResource(listTracabilite[position].getImg());
}


@Override
public int getItemCount() {
        return listTracabilite.length;
        }

public static class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageuser;
    public TextView distuser;
    public ViewHolder(View itemView) {
        super(itemView);
       this.imageuser = (ImageView) itemView.findViewById(R.id.imageuser);
        this.distuser = (TextView) itemView.findViewById(R.id.distanceUser);

    }
}
}
