package com.example.readshare.DemandeRecu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.DemandeEnvoye.ListReceived;
import com.example.readshare.DemandeEnvoye.ReceivedAdapter;
import com.example.readshare.R;

public class SentAdapter extends RecyclerView.Adapter<SentAdapter.ViewHolder>{
    private ListSent[] lstSent;

    // RecyclerView recyclerView;
    public SentAdapter(ListSent[] listSent) {
        this.lstSent =listSent ;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_sent, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListSent myListsent = lstSent[position];
        holder.username.setText(lstSent[position].getUsername());
        holder.message.setText(lstSent[position].getMessage());
        holder.imageView.setImageResource(lstSent[position].getImgId());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListsent.getUsername(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return lstSent.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView username;
        public TextView message;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.username = (TextView) itemView.findViewById(R.id.username);
            this.message = (TextView) itemView.findViewById(R.id.msg);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}

