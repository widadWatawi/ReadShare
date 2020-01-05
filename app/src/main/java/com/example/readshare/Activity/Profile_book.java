package com.example.readshare.Activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.readshare.Activity.RechercheLivre.MyMenu;
import com.example.readshare.Model.User;
import com.example.readshare.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Profile_book extends MyMenu {


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

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.profile_book, null, false);
        drawer.addView(contentView, 0);
        ButterKnife.bind(this);

        Log.d("widad", "widad");


        Intent intent = getIntent();

        user = (User)intent.getSerializableExtra("user");



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
