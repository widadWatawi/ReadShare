package com.example.readshare.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.readshare.R;
import com.example.readshare.Activity.RechercheLivre.MyMenu;
import com.example.readshare.ResponseAuth;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    EditText UsernameEt, PasswordEt;

    Button btnLogin , btnSignin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnSignin = findViewById(R.id.btnSignin);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                new HttpReqTask().execute();
            }
        });


        btnSignin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Inscription.class);
                startActivity(intent);
            }
        });

    }


    class HttpReqTask extends AsyncTask<Void,Void, ResponseAuth> {




        @SuppressLint("WrongThread")
        @Override
        protected ResponseAuth doInBackground(Void... voids) {


            UsernameEt = findViewById(R.id.etUserName);
            PasswordEt = findViewById(R.id.etPassword);
            try{

                String apiUrl = "http://192.168.0.165:8081/rest/login/{login}/{password}";
                RestTemplate rt = new RestTemplate();
                rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Map<String, Object> params = new HashMap<>();

                params.put("login", UsernameEt.getText().toString());
                params.put("password", PasswordEt.getText().toString());

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
                    Intent intent = new Intent(getApplicationContext(), MyMenu.class);

                    startActivity(intent);
                }
            }catch (Exception e){
                Log.i("",e.getMessage());
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), "fail to authenticate", duration);
                toast.show();
            }





        }
    }
    /*
    public class HttpReqTask extends AsyncTask<Void,Void,ResponseAuth> {

        @Override
        protected ResponseAuth doInBackground(Void... voids) {

            try{
                String apiUrl = "http://192.168.0.157:8888/rest/login/{login}/{password}";
                RestTemplate rt = new RestTemplate();
                rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Map<String, Object> params = new HashMap<>();
                params.put("login", UsernameEt.getText().toString());
                params.put("password", PasswordEt.getText().toString());

                ResponseAuth ro = rt.getForObject(apiUrl,ResponseAuth.class,params);
                return ro;
            }catch(Exception ex){
                Log.e("",ex.getMessage());
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
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);
                }
            }catch (Exception e){
                Log.i("",e.getMessage());
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), "fail to authenticate", duration);
                toast.show();
            }




            }

        }
    }
    */


}
