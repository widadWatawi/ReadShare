package com.example.readshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.readshare.Activity.Inscription;
import com.example.readshare.Activity.RechercheLivre.MyMenu;


public class MainActivity extends AppCompatActivity {

    Button btnsignup;
    Button btnsignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsignup = findViewById(R.id.btnLogin);
        btnsignin=findViewById(R.id.btnSignin);
        btnsignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), Inscription.class);
                startActivity(intent);
               }
        });
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), MyMenu.class);
                startActivity(intent);
            }
        });

    }


}
