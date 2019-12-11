package com.example.readshare.DemandeLivre;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.R;


public class DemanderLivre extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demander_livre);
        ListDemandeLivre[] myListData = new ListDemandeLivre[] {
                new ListDemandeLivre("Contes","150m", R.drawable.img1),
                new ListDemandeLivre("Le père goriot","2km", R.drawable.img2),
                new ListDemandeLivre("Antigone","4km", R.drawable.img3),
                new ListDemandeLivre("Boîte à merveille","300m", R.drawable.img4),
                new ListDemandeLivre("Sans Famille", "350m",R.drawable.img5),
                new ListDemandeLivre("Le monde s'effronde","5km", R.drawable.img6),
                new ListDemandeLivre("Madame Bovary","400m", R.drawable.img7),

        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        demandeLivreAdapter adapter = new demandeLivreAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}

