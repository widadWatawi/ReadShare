package com.example.readshare.Activity.main;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.Model.Demande;
import com.example.readshare.Model.Employee;
import com.example.readshare.Model.Livre;
import com.example.readshare.R;

import java.util.List;

public class ReceivedAdapter  extends RecyclerView.Adapter<ReceivedAdapter.ViewHolder>{
    private List<Demande> lstReceived;

    // RecyclerView recyclerView;
    public ReceivedAdapter(List<Demande> lstReceived) {
        this.lstReceived =lstReceived ;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_received, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //final ListReceived myListreceived = lstReceived[position];
        //Log.d("hh",lstReceived.get(position).getLivre_received().getTitre());
        holder.titre.setText(lstReceived.get(position).getLivre_received().getTitre());
        holder.nom.setText(lstReceived.get(position).getUser_sender().getNom());
        /*holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListreceived.getUsername(),Toast.LENGTH_LONG).show();
            }
        });*/
    }


    @Override
    public int getItemCount() {
        return lstReceived.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titre;
        public TextView nom;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);

            this.titre = (TextView) itemView.findViewById(R.id.titre);
            this.nom = (TextView) itemView.findViewById(R.id.nom);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}
