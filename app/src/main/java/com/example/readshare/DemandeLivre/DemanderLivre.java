package com.example.readshare.DemandeLivre;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.R;
import com.example.readshare.RechercheLivre.MyMenu;



public class DemanderLivre extends AppCompatActivity {
    MyMenu myMenu;

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

