package com.example.readshare;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class AjouterLivre extends AppCompatActivity {


    EditText titre, auteur,description,genre;

    Button btnadd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter_livre);

        btnadd = findViewById(R.id.btnadd);

        btnadd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                new HttpReqTask().execute();
            }
        });

    }
    class HttpReqTask extends AsyncTask<Void,Void, ResponseAuth> {

        @SuppressLint("WrongThread")

        protected ResponseAuth doInBackground(Void... voids) {
            titre = findViewById(R.id.titre);
            auteur= findViewById(R.id.auteur);
            genre =findViewById(R.id.genre);
            description =findViewById(R.id.description);
            try{

                String apiUrl = "http://192.168.1.94:8082/api/livres/{titre}/{auteur}/{genre}/{description}";
                RestTemplate rt = new RestTemplate();
                rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Map<String, Object> params = new HashMap<>();

                params.put("titre", titre.getText().toString());
                params.put("auteur", auteur.getText().toString());
                params.put("genre", genre.getText().toString());
                params.put("description", description.getText().toString());

                ResponseAuth ro = rt.getForObject(apiUrl,ResponseAuth.class,params);
                return ro;
            }catch(Exception ex){
                Log.e("###################",ex.getMessage());
            }
            return null;
        }
        protected void onPostExecute(ResponseRegist rr){
            super.onPostExecute(rr);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(getApplicationContext(), rr.getMessage(), duration);
            toast.show();

            if(!rr.getSuccess()){

                toast = Toast.makeText(getApplicationContext(), rr.getMessage(), duration);
                toast.show();
            }
            else {


            }




        }




    }


    }
