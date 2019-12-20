package com.example.readshare;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    ArrayList<MainModel> mainModelS;
    Context context ;
    public MainAdapter(Context context, ArrayList<MainModel> mainModels){
        this.context = context;
        this.mainModelS =mainModels ;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);

        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder, int position){

        holder.imageView.setImageResource(mainModelS.get(position).getLangLogo());

        holder.textView.setText(mainModelS.get(position).getLangName());
    }
    public int getItemCount() {
        return mainModelS.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
        }
    }

}