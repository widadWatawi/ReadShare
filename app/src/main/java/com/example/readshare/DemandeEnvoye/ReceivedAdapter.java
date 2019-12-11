package com.example.readshare.DemandeEnvoye;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import com.example.readshare.R;

public class ReceivedAdapter extends RecyclerView.Adapter<ReceivedAdapter.ViewHolder>{
    private ListReceived[] lstReceived;

    // RecyclerView recyclerView;
    public ReceivedAdapter(ListReceived[] lstReceived) {
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
        final ListReceived myListreceived = lstReceived[position];
        holder.username.setText(lstReceived[position].getUsername());
        holder.message.setText(lstReceived[position].getMessage());
        holder.imageView.setImageResource(lstReceived[position].getImgId());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListreceived.getUsername(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return lstReceived.length;
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
