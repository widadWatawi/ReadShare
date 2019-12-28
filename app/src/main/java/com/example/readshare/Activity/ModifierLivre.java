package com.example.readshare.Activity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.readshare.Activity.RechercheLivre.MyMenu;
import com.example.readshare.R;
import com.example.readshare.ResponseAuth;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class ModifierLivre extends MyMenu {


    EditText titre, auteur,description,genre;

    Button btnedit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.modifier_livre, null, false);
        drawer.addView(contentView, 0);

        btnedit = findViewById(R.id.btnedit);

        btnedit.setOnClickListener(new View.OnClickListener(){
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

                String apiUrl = "http://192.168.0.165:8081/api/ModifyBook/{id}/{titre}/{auteur}/{genre}/{date}/{description}/{note}/{photo}";
                RestTemplate rt = new RestTemplate();
                rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Map<String, Object> params = new HashMap<>();

                //id a recuperer
                params.put("id", 8);
                params.put("titre", titre.getText().toString());
                params.put("auteur", auteur.getText().toString());
                params.put("genre", genre.getText().toString());
                params.put("date", "3-13-1996");
                params.put("note", 5);
                params.put("description", description.getText().toString());
                params.put("photo", " ");

                ResponseAuth ro = rt.getForObject(apiUrl,ResponseAuth.class,params);
                return ro;
            }catch(Exception ex){
                Log.e("###################",ex.getMessage());
            }
            return null;
        }
        protected void onPostExecute(ResponseAuth ro){
            super.onPostExecute(ro);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(getApplicationContext(), ro.getMessage(), duration);
            toast.show();






        }




    }


}
