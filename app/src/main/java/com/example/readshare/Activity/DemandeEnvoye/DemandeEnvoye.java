package com.example.readshare.Activity.DemandeEnvoye;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.R;

public class DemandeEnvoye extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demande_envoye);
        ListReceived[] lstReceived = new ListReceived[] {
                new ListReceived("Contes","150m", R.drawable.img1),
                new ListReceived("Le père goriot","2km", R.drawable.img2),
                new ListReceived("Antigone","4km", R.drawable.img3),
                new ListReceived("Boîte à merveille","300m", R.drawable.img4),
                new ListReceived("Sans Famille", "350m",R.drawable.img5),
                new ListReceived("Le monde s'effronde","5km", R.drawable.img6),
                new ListReceived("Madame Bovary","400m", R.drawable.img7),

        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ReceivedAdapter adapter = new ReceivedAdapter(lstReceived);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
