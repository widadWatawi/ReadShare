package com.example.readshare.Activity.DemandeLivre;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.Model.Livre;
import com.example.readshare.Network.LivreService;
import com.example.readshare.Network.RetrofitClient;
import com.example.readshare.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DemanderLivre extends AppCompatActivity {


    RecyclerView recyclerView;
    demandeLivreAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demander_livre);
        /*Create handle for the RetrofitInstance interface*/
        LivreService service = RetrofitClient.getClient().create(LivreService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<List<Livre>> call = service.getLivres();

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

            adapter = new demandeLivreAdapter(empDataList);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DemanderLivre.this);

            recyclerView.setLayoutManager(layoutManager);

            recyclerView.setAdapter(adapter);
        }


    }


