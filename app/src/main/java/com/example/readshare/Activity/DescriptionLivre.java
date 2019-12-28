package com.example.readshare.Activity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.readshare.Activity.RechercheLivre.MyMenu;
import com.example.readshare.R;
import com.example.readshare.ResponseRegist;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DescriptionLivre  extends MyMenu {

    @BindView(R.id.titre)
    TextView titre;

    @BindView(R.id.auteur)
    TextView auteur;

    @BindView(R.id.genre)
    TextView genre;

    @BindView(R.id.date)
    TextView date;

    @BindView(R.id.distance)
    TextView distance;

    @BindView(R.id.description)
    TextView description;

    @BindView(R.id.profile)
    Button profile;

    @BindView(R.id.send_request)
    Button sendRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.description_livre, null, false);
        drawer.addView(contentView, 0);
        ButterKnife.bind(this);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Profile.class);
                startActivity(intent);
            }
        });
        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DescriptionLivre.HttpReqTask().execute();
            }
        });

    }

    class HttpReqTask extends AsyncTask<Void, Void, ResponseRegist> {

        @SuppressLint("WrongThread")
        @Override
        protected ResponseRegist doInBackground(Void... voids) {
            titre = findViewById(R.id.titre);
            auteur= findViewById(R.id.auteur);
            genre =findViewById(R.id.genre);
            description =findViewById(R.id.description);
            try{

                String apiUrl = "http://192.168.0.165:8081/demande/sendRequest/{idLivre}/{idsender}/{date}";
                RestTemplate rt = new RestTemplate();
                rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Map<String, Object> params = new HashMap<>();

                //id a recuperer
                params.put("idLivre", 18);
                SharedPreferences prefs = getSharedPreferences("UserFile",Context.MODE_PRIVATE);
                long id = prefs.getLong("idUser",0);
                params.put("idsender", id);
                params.put("date", "13-3-1996");


                ResponseRegist rr = rt.getForObject(apiUrl,ResponseRegist.class,params);
                return rr;


            }catch(Exception ex){
                Log.e("#############",ex.getMessage());
            }
            return null;
        }

        protected void onPostExecute(ResponseRegist rr){
            super.onPostExecute(rr);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(getApplicationContext(), rr.getMessage(), duration);
            toast.show();

        }


    }

    @Override
    protected void onResume() {
        super.onResume();


        titre.setText("Titre");
        auteur.setText("Auteur");
        genre.setText("Genre");
        date.setText("Date");
        distance.setText("200m");
        description.setText("kjhljhkjhkjhlkjlkjmlkjmklmlkmkmlmjlqkjlfjlfjqhlkhflkjqflkjlfkjqlkfjlqkjflqkjlqkjlfjkl");


    }
}
