package com.example.readshare.Activity.RechercheLivre;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import com.example.readshare.Activity.Acceuil;

import com.example.readshare.Activity.DemandeLivre.DemanderLivre;
import com.example.readshare.Activity.Library;
import com.example.readshare.Activity.Message;
import com.example.readshare.Activity.Profile;
import com.example.readshare.Model.NoteId;
import com.example.readshare.R;
import com.google.android.material.navigation.NavigationView;

import java.util.List;


public class MyMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    public DrawerLayout drawer;
    public Button search;
    public FrameLayout contentFrameLayout;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //setTitle("Menu");

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        search = findViewById(R.id.search_btn);
        contentFrameLayout = findViewById(R.id.fragment_container);

        SharedPreferences prefs = getSharedPreferences("UserFile",Context.MODE_PRIVATE);
        long id = prefs.getLong("idUser",0);
        //Toast toast = Toast.makeText(getApplicationContext(), "the user id :"+id, Toast.LENGTH_SHORT);
        //toast.show();

        search.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), RechercheLivre2.class);
                startActivity(intent);
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        /*
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

         */
    }




    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent=null;
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                intent=new Intent(getApplicationContext(), Acceuil.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                intent=new Intent(getApplicationContext(), Profile.class);
                startActivity(intent);
                break;
            case R.id.nav_library:
                intent=new Intent(getApplicationContext(), Library.class);
                startActivity(intent);
                break;
            case R.id.nav_message:
                intent=new Intent(getApplicationContext(), Message.class);
                startActivity(intent);
                break;
            case R.id.nav_request:
                intent=new Intent(getApplicationContext(), DemanderLivre.class);
                startActivity(intent);
                break;



        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void setToolBar(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    protected void onStop() {
        finish();
        super.onStop();
    }

    }
