package com.example.readshare.Activity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.readshare.R;
import com.example.readshare.ResponseRegist;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Inscription extends AppCompatActivity {

    EditText login,FirstName,LastName,Email,Password,Password2;
    Button btnLogin , btnSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        btnSignin = findViewById(R.id.btnSignin);
        Password = findViewById(R.id.etPassword);
        login = findViewById(R.id.etlogin);
        FirstName = findViewById(R.id.etFirstName);
        LastName = findViewById(R.id.etLastName);
        Email = findViewById(R.id.etEmail);
        Password2 = findViewById(R.id.etPassword2);


        btnSignin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                new HttpReqTask().execute();
            }
        });




    }

    class HttpReqTask extends AsyncTask<Void, Void,ResponseRegist> {

        @SuppressLint("WrongThread")
        @Override
        protected ResponseRegist doInBackground(Void... voids) {

            try{

                if(Password.getText().toString().equals(Password2.getText().toString())){
                    String apiUrl = "http://192.168.0.165:8888/rest/registration/{login}/{firstname}/{lastname}/{email}/{password}";
                    RestTemplate rt = new RestTemplate();
                    rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                    Map<String, Object> params = new HashMap<>();
                    params.put("login", login.getText().toString());
                    params.put("firstname", FirstName.getText().toString());
                    params.put("lastname", LastName.getText().toString());
                    params.put("email", Email.getText().toString());
                    params.put("password", Password.getText().toString());
                    ResponseRegist rr = rt.getForObject(apiUrl,ResponseRegist.class,params);
                    return rr;
                }
                else{
                    ResponseRegist rr = new ResponseRegist();
                    rr.setMessage("password not confirmed");
                    return rr;
                }


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

            if(!rr.getSuccess()){

                toast = Toast.makeText(getApplicationContext(), rr.getMessage(), duration);
                toast.show();
            }
            else {


            }




        }


    }


}
