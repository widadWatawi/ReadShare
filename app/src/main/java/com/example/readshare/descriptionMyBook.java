package com.example.readshare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.readshare.Activity.MainActivity;
import com.example.readshare.Activity.RechercheLivre.MyMenu;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class descriptionMyBook extends AppCompatActivity {


    Button btnModify , btnDelete;

    long idLivre=8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_my_book);

        btnModify = findViewById(R.id.Modify);
        btnDelete = findViewById(R.id.Delete);

        btnModify.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent = new Intent(getApplicationContext(), MyMenu.class);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                new HttpReqTask().execute();


            }
        });
    }
    public class HttpReqTask extends AsyncTask<Void,Void, ResponseAuth> {




        @SuppressLint("WrongThread")
        @Override
        protected ResponseAuth doInBackground(Void... voids) {



            try{

                String apiUrl = "http://192.168.0.165:8081/api/deleteBook/{id}";
                RestTemplate rt = new RestTemplate();
                rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Map<String, Object> params = new HashMap<>();

                params.put("id", idLivre);

                ResponseAuth ro = rt.getForObject(apiUrl,ResponseAuth.class,params);
                return ro;
            }catch(Exception ex){
                Log.e("###################",ex.getMessage());
            }
            return null;
        }
        protected void onPostExecute(ResponseAuth ro){
            super.onPostExecute(ro);
            try{
                if(!ro.getSuccess()){
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(getApplicationContext(), ro.getMessage(), duration);
                    toast.show();
                }
                else {
                    int duration = Toast.LENGTH_SHORT;


                    Toast toast = Toast.makeText(getApplicationContext(), ro.getMessage(), duration);
                    toast.show();


                    //Intent intent = new Intent(getApplicationContext(), MyMenu.class);
                    //startActivity(intent);
                }
            }catch (Exception e){
                Log.i("#####################",e.getMessage());
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), "fail to delete", duration);
                toast.show();
            }





        }
    }
}
