package com.example.readshare.Activity.RechercheLivre;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
import com.example.readshare.Activity.DescriptionLivre;
import com.example.readshare.Activity.Message;
import com.example.readshare.Activity.Profile;
import com.example.readshare.Activity.bibliotheque;
import com.example.readshare.Model.Livre;
import com.example.readshare.Model.User;
import com.example.readshare.Network.LivreService;
import com.example.readshare.Network.RetrofitClient;
import com.example.readshare.Network.UserService;
import com.example.readshare.R;
import com.google.android.material.navigation.NavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MyMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    public DrawerLayout drawer;
    public Button search;
    public FrameLayout contentFrameLayout;
    public Toolbar toolbar;

    public User user;

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


        UserService service = RetrofitClient.getClient().create(UserService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<User> call = service.getUser(id);

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    user= response.body();


                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MyMenu.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });


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
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent=null;
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                intent=new Intent(getApplicationContext(), Acceuil.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                intent=new Intent(getApplicationContext(), Profile.class);
                intent.putExtra("user", user);
                startActivity(intent);
                break;
            case R.id.nav_library:
                intent=new Intent(getApplicationContext(), bibliotheque.class);
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


    }
