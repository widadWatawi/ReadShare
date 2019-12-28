package com.example.readshare.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.Activity.DemandeLivre.DemanderLivre;
import com.example.readshare.Activity.DemandeLivre.demandeLivreAdapter;
import com.example.readshare.Model.Livre;
import com.example.readshare.Network.LivreService;
import com.example.readshare.Network.RetrofitClient;
import com.example.readshare.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Acceuil extends AppCompatActivity {


    ViewFlipper V_flipper;
    RecyclerView recyclerView;
    RecyclerView recyclerView_note;
    RecyclerView recyclerView_last;

    MainAdapter mainAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceuil);
        int images[] ={R.drawable.slide, R.drawable.slide2};
        V_flipper =  findViewById(R.id.V_flipper);
        recyclerView= findViewById(R.id.recycler_view);
        if(recyclerView == null){
            Log.d("tst", "null");
        }


        LivreService service = RetrofitClient.getClient().create(LivreService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<List<Livre>> call = service.getLivres();

        Call<List<Livre>> callbest = service.getBest();
        Call<List<Livre>> calllast = service.getLast();

        /*Log the URL called*/
        Log.wtf("URL Called", callbest.request().url() + "");

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
                Toast.makeText(Acceuil.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });


        callbest.enqueue(new Callback<List<Livre>>() {

            @Override
            public void onResponse(Call<List<Livre>> call, Response<List<Livre>> response) {
                if (response.isSuccessful()) {
                    List<Livre> livres= response.body();
                    generateEmployeeList_note(livres);

                }
            }

            @Override
            public void onFailure(Call<List<Livre>> call, Throwable t) {
                Toast.makeText(Acceuil.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });


        calllast.enqueue(new Callback<List<Livre>>() {

            @Override
            public void onResponse(Call<List<Livre>> call, Response<List<Livre>> response) {
                if (response.isSuccessful()) {
                    List<Livre> livres= response.body();
                    generateEmployeeList_last(livres);
                }
            }

            @Override
            public void onFailure(Call<List<Livre>> call, Throwable t) {
                Toast.makeText(Acceuil.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });




        for (int i=0 ;i< images.length ;i++){
            flipperImages(images[i]);

        }

        for (int image:images){
            flipperImages(image);
        }
    }


    private void generateEmployeeList_note(List<Livre> empDataList) {

        recyclerView_note = findViewById(R.id.recycler_note);
        mainAdapter = new MainAdapter(empDataList,new MainAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(Livre livre){
                Intent intent = new Intent(Acceuil.this, DescriptionLivre.class);
                intent.putExtra("livreId", livre.getId()+"");

                startActivity(intent);
            }
        });
        LinearLayoutManager layoutManager_note = new LinearLayoutManager(
                Acceuil.this,LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView_note.setLayoutManager(layoutManager_note);
        recyclerView_note.setItemAnimator(new DefaultItemAnimator());
        recyclerView_note.setAdapter(mainAdapter);
    }

    private void generateEmployeeList_last(List<Livre> empDataList) {

        recyclerView_last = findViewById(R.id.recycler_last);
         mainAdapter = new MainAdapter(empDataList,new MainAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(Livre livre){
                Intent intent = new Intent(Acceuil.this, DescriptionLivre.class);
                intent.putExtra("livreId", livre.getId()+"");
                startActivity(intent);
            }
        });
        LinearLayoutManager layoutManager_note = new LinearLayoutManager(
                Acceuil.this,LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView_last.setLayoutManager(layoutManager_note);
        recyclerView_last.setItemAnimator(new DefaultItemAnimator());
        recyclerView_last.setAdapter(mainAdapter);
    }


    private void generateEmployeeList(List<Livre> empDataList) {

       recyclerView = findViewById(R.id.recycler_view);
        mainAdapter = new MainAdapter(empDataList,new MainAdapter.OnItemClickListener(){
            @Override
                public void onItemClick(Livre livre){
                Log.d("id","baba");
                Intent intent = new Intent(Acceuil.this, DescriptionLivre.class);
                intent.putExtra("livreId", livre.getId()+"");
                startActivity(intent);
            }
        });

     LinearLayoutManager layoutManager = new LinearLayoutManager(
                Acceuil.this,LinearLayoutManager.HORIZONTAL,false
        );

      recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mainAdapter);


    }



    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        V_flipper.addView(imageView);
        V_flipper.setFlipInterval(4000);

        V_flipper.setAutoStart(true);

        //annimation
        V_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        V_flipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}
