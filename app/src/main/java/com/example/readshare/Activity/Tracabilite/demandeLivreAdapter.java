package com.example.readshare.Activity.Tracabilite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.Model.Livre;
import com.example.readshare.Model.User;
import com.example.readshare.R;

import java.util.List;

public class demandeLivreAdapter extends RecyclerView.Adapter<demandeLivreAdapter.ViewHolder>{

private List<User> listdata;


// RecyclerView recyclerView;
public demandeLivreAdapter(List<User> listdata) {
        this.listdata = listdata;

        }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        //  public ImageView imageView;
        public TextView nom;
        public TextView distance;
        //public TextView distance;
        //public Button request;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            // this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.nom = (TextView) itemView.findViewById(R.id.nom);
            this.distance= (TextView) itemView.findViewById(R.id.distance);
            //this.distance = (TextView) itemView.findViewById(R.id.distance);
            //this.request=itemView.findViewById(R.id.request);
            linearLayout =itemView.findViewById(R.id.linearLayout);

        }


        public void bind(final User item) {


           nom.setText(item.getNom()+" "+item.getPrenom());
           distance.setText(item.getVille());

        }


    }

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_tracabilitelivre, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
        }

@Override
public void onBindViewHolder(ViewHolder holder, int position) {
    holder.bind(listdata.get(position));

        }


@Override
public int getItemCount() {
        return listdata.size();
        }

    public User getItem(int position){
        return listdata.get(position);
    }


    public interface OnItemClickListener {
        void onItemClick(User user);
    }




}
