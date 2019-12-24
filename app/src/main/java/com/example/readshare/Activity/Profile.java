package com.example.readshare.Activity;

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
import com.example.readshare.R;
import com.example.readshare.ResponseAuth;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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

    @BindView(R.id.edit_user)
    TextView editBtn;

    int id = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        ButterKnife.bind(this);

        editBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), ModifierProfile.class);
                startActivity(intent);
            }

        });


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
