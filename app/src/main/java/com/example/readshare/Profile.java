package com.example.readshare;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Profile extends AppCompatActivity {


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
        setContentView(R.layout.profile);
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
