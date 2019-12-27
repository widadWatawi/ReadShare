package com.example.readshare;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.Activity.RechercheLivre.MyMenu;

import java.util.ArrayList;

public class Acceuil extends MyMenu {


    ViewFlipper V_flipper;
    RecyclerView recyclerView;

    ArrayList<MainModel> mainModels ;
    MainAdapter mainAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.acceuil, null, false);
        drawer.addView(contentView, 0);
        int images[] ={R.drawable.slide, R.drawable.slide2};
        V_flipper =  findViewById(R.id.V_flipper);
        recyclerView= findViewById(R.id.recycler_view);
        if(recyclerView == null){
            Log.d("tst", "null");
        }
        Integer[] langLogo ={R.drawable.dotnet,R.drawable.dotnet,R.drawable.dotnet,R.drawable.dotnet};
        String[] langName = {"first book","Dracula","third book","aux champs"};
        mainModels =new ArrayList<>();
        for (int i=0;i<langLogo.length;i++){
            MainModel model =new MainModel(langLogo[i],langName[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                Acceuil.this,LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter( Acceuil.this,mainModels);
        recyclerView.setAdapter(mainAdapter);

        for (int i=0 ;i< images.length ;i++){
            flipperImages(images[i]);

        }

        for (int image:images){
            flipperImages(image);
        }
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

