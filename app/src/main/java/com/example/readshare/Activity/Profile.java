package com.example.readshare.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.readshare.Activity.RechercheLivre.MyMenu;
import com.example.readshare.R;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.profile, null, false);
        drawer.addView(contentView, 0);
        ButterKnife.bind(this);

    }


    @Override
    protected void onResume() {
        super.onResume();


        login.setText("Login");
        first_name.setText("First Name");
        last_name.setText("Last Name");
        email.setText("Email");
        city.setText("Ville");


    }
}
