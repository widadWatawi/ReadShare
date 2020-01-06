package com.example.readshare.Activity.DemandeLivre;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.readshare.Model.Livre;
import com.example.readshare.R;

import java.util.ArrayList;
import java.util.List;

public class demandeLivreAdapter extends RecyclerView.Adapter<demandeLivreAdapter.ViewHolder>{

private List<Livre> listdata;
private OnItemClickListener listener;


// RecyclerView recyclerView;
public demandeLivreAdapter(List<Livre> listdata, OnItemClickListener listener) {
        this.listdata = listdata;
        this.listener = listener;
        }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        //  public ImageView imageView;
        public TextView titre;
        //public TextView distance;
        //public Button request;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            // this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.titre = (TextView) itemView.findViewById(R.id.titreLivre);
            //this.distance = (TextView) itemView.findViewById(R.id.distance);
            //this.request=itemView.findViewById(R.id.request);
            linearLayout =itemView.findViewById(R.id.linearLayout);

        }


        public void bind(final Livre item, final OnItemClickListener listener) {


            titre.setText(item.getTitre());

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    listener.onItemClick(item);


                }

            });

        }


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
    holder.bind(listdata.get(position), listener);

        }


@Override
public int getItemCount() {
        return listdata.size();
        }

    public Livre getItem(int position){
        return listdata.get(position);
    }


    public interface OnItemClickListener {
        void onItemClick(Livre livre);
    }




}
