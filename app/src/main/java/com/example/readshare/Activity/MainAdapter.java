package com.example.readshare.Activity;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.OnItemClickListener;
import com.example.readshare.Activity.DemandeLivre.demandeLivreAdapter;
import com.example.readshare.Model.Livre;
import com.example.readshare.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    List<Livre> mainModelS;
    Context context ;
    private OnItemClickListener listener;

    public MainAdapter(List<Livre> mainModels, OnItemClickListener listener){
        this.mainModelS =mainModels ;
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
        }

        public void bind(final Livre item, final OnItemClickListener listener) {


            textView.setText(item.getTitre());

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    listener.onItemClick(item);

                }

            });

        }

    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);

        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder, int position){

       // holder.imageView.setImageResource(mainModelS.get(position).getLangLogo());
        holder.bind(mainModelS.get(position), listener);
    }
    public int getItemCount() {
        return mainModelS.size();
    }



    public Livre getItem(int position){
        return mainModelS.get(position);
    }


    public interface OnItemClickListener {
        void onItemClick(Livre livre);
    }



}