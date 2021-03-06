package com.example.readshare.Activity;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.readshare.Activity.RechercheLivre.MyMenu;
import com.example.readshare.Model.User;
import com.example.readshare.R;
import com.example.readshare.ResponseAuth;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Profile extends MyMenu {


    @BindView(R.id.login)
    TextView login;

    @BindView(R.id.first_name)
    TextView first_name;

    @BindView(R.id.last_name)
    TextView last_name;

    @BindView(R.id.email)
    TextView email;

    @BindView(R.id.city)
    TextView city;

    @BindView(R.id.edit_user)
    TextView editBtn;

    @BindView(R.id.delete_user)
    TextView deleteBtn;

    User user;

    int id = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.profile, null, false);
        drawer.addView(contentView, 0);
        ButterKnife.bind(this);


        Intent intent = getIntent();

        user = (User)intent.getSerializableExtra("user");


        editBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), ModifierProfile.class);
                intent.putExtra("login",user.getLogin());
                startActivity(intent);
            }

        });

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }

        });

    }


    @Override
    protected void onResume() {
        super.onResume();


        login.setText(user.getLogin());
        first_name.setText(user.getPrenom());
        last_name.setText(user.getNom());
        email.setText(user.getEmail());
        city.setText(user.getVille());


    }
}
