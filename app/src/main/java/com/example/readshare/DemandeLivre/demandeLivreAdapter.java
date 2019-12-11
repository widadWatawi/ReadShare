package com.example.readshare.DemandeLivre;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.R;

class demandeLivreAdapter extends RecyclerView.Adapter<demandeLivreAdapter.ViewHolder>{
private ListDemandeLivre[] listdata;

// RecyclerView recyclerView;
public demandeLivreAdapter(ListDemandeLivre[] listdata) {
        this.listdata = listdata;
        }
@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_demandelivre, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
        }

@Override
public void onBindViewHolder(ViewHolder holder, int position) {
final ListDemandeLivre myListData = listdata[position];
        holder.titre.setText(listdata[position].getTitre());
        holder.distance.setText(listdata[position].getDistance());
        holder.imageView.setImageResource(listdata[position].getImgId());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        Toast.makeText(view.getContext(),"click on item: "+myListData.getTitre(),Toast.LENGTH_LONG).show();
        }
        });
        }


@Override
public int getItemCount() {
        return listdata.length;
        }

public static class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView titre;
    public TextView distance;
    public RelativeLayout relativeLayout;
    public ViewHolder(View itemView) {
        super(itemView);
        this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
        this.titre = (TextView) itemView.findViewById(R.id.titreLivre);
        this.distance = (TextView) itemView.findViewById(R.id.distance);
        relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
    }
}
}
