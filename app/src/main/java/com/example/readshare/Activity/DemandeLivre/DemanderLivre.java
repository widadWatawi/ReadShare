package com.example.readshare.Activity.DemandeLivre;


import android.app.Activity;
import android.content.Intent;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.readshare.Activity.DescriptionLivre;

import com.example.readshare.Activity.RechercheLivre.MyMenu;

import com.example.readshare.Model.Livre;
import com.example.readshare.Network.LivreService;
import com.example.readshare.Network.RetrofitClient;
import com.example.readshare.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;




public class DemanderLivre extends MyMenu {


    RecyclerView recyclerView;
    demandeLivreAdapter adapter;

    String genre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.demander_livre, null, false);
        drawer.addView(contentView, 0);
        setContentView(R.layout.demander_livre);
        /*Create handle for the RetrofitInstance interface*/
        LivreService service = RetrofitClient.getClient().create(LivreService.class);


       /*Intent intent = getIntent();
        genre =intent.getStringExtra("genre");*/
        Call<List<Livre>> call;
        call = service.getLivres();

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<List<Livre>>() {

            @Override
            public void onResponse(Call<List<Livre>> call, Response<List<Livre>> response) {
                if (response.isSuccessful()) {
                    List<Livre> livres= response.body();
                    generateEmployeeList(livres);
                }
            }

            @Override
            public void onFailure(Call<List<Livre>> call, Throwable t) {
                Toast.makeText(DemanderLivre.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        }


        private void generateEmployeeList(List<Livre> empDataList) {
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

            adapter = new demandeLivreAdapter(empDataList,new demandeLivreAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(Livre livre){
                Intent intent = new Intent(DemanderLivre.this, DescriptionLivre.class);
                intent.putExtra("livreId", livre.getId()+"");
                startActivity(intent);
            }
        });

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DemanderLivre.this);

            recyclerView.setLayoutManager(layoutManager);

            recyclerView.setAdapter(adapter);
        }




    }


