package com.example.readshare.Activity.DemandeRecu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.R;

public class DemandeRecu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demande_recu);
        ListSent[] lstsent = new ListSent[] {
                new ListSent("Contes","150m", R.drawable.img1),
                new ListSent("Le père goriot","2km", R.drawable.img2),
                new ListSent("Antigone","4km", R.drawable.img3),
                new ListSent("Boîte à merveille","300m", R.drawable.img4),
                new ListSent("Sans Famille", "350m",R.drawable.img5),
                new ListSent("Le monde s'effronde","5km", R.drawable.img6),
                new ListSent("Madame Bovary","400m", R.drawable.img7),

        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        SentAdapter adapter = new SentAdapter(lstsent);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
