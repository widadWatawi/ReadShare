package com.example.readshare.Activity;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.example.readshare.ResponseRegist;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class AjouterLivre extends MyMenu {

    EditText titre, auteur,description,genre;
    Button addBook;

    long idBook,idUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.ajouter_livre, null, false);
        drawer.addView(contentView, 0);


        addBook = findViewById(R.id.btnadd);

        addBook.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                new AjouterLivre.HttpReqTask().execute();
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

                String apiUrl = "http://192.168.0.165:8081/api/addBook/{titre}/{auteur}/{genre}/{date}/{description}/{note}/{photo}/{id_actual}";
                RestTemplate rt = new RestTemplate();
                rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Map<String, Object> params = new HashMap<>();


                params.put("titre", titre.getText().toString());
                params.put("auteur", auteur.getText().toString());
                params.put("genre", genre.getText().toString());
                params.put("date", "3-13-1996");
                params.put("note", 5);
                params.put("description", description.getText().toString());
                params.put("photo", " ");

                SharedPreferences prefs = getSharedPreferences("UserFile",Context.MODE_PRIVATE);
                long id = prefs.getLong("idUser",0);
                params.put("id_actual", id);

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

            idBook = rr.getIdBook();
            SharedPreferences prefs = getSharedPreferences("UserFile", Context.MODE_PRIVATE);
            idUser = prefs.getLong("idUser",0);

            new AjouterLivre.HttpReqTask2().execute();
        }


    }
    class HttpReqTask2 extends AsyncTask<Void, Void, ResponseRegist> {

        @SuppressLint("WrongThread")
        @Override
        protected ResponseRegist doInBackground(Void... voids) {

            try{

                String apiUrl = "http://192.168.0.165:8081/api/addBookInHistory/{idUser}/{idLivre}/{date}";
                RestTemplate rt = new RestTemplate();
                rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Map<String, Object> params = new HashMap<>();

                //id a recuperer
                params.put("idUser", idUser);
                params.put("idLivre", idBook);
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
            if(!rr.getSuccess()){
                Toast toast = Toast.makeText(getApplicationContext(), rr.getMessage(), duration);
                toast.show();
            }





        }


    }
}

