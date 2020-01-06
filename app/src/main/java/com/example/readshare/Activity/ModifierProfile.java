package com.example.readshare.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.readshare.Activity.RechercheLivre.MyMenu;
import com.example.readshare.R;
import com.example.readshare.ResponseAuth;
import com.example.readshare.ResponseRegist;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ModifierProfile extends MyMenu {


    @BindView(R.id.LOGIN)
    TextView login;

    @BindView(R.id.PRENOM)
    TextView first_name;

    @BindView(R.id.NOM)
    TextView last_name;

    @BindView(R.id.EMAIL)
    TextView email;

    @BindView(R.id.VILLE)
    TextView city;

    @BindView(R.id.Tel)
    TextView tel;

    @BindView(R.id.btnadd)
    TextView editBtn;

    String Userlogin ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.modifier_profile, null, false);
        drawer.addView(contentView, 0);
        ButterKnife.bind(this);

        Userlogin= getIntent().getExtras().getString("login");
        editBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                new ModifierProfile.HttpReqTask().execute();
            }

        });


    }


        class HttpReqTask extends AsyncTask<Void,Void, ResponseRegist> {




            @SuppressLint("WrongThread")
            @Override
            protected ResponseRegist doInBackground(Void... voids) {



                try{

                    String apiUrl = "http://192.168.0.165:8081/rest/Modify/{loginPrevious}/{login}/{firstname}/{lastname}/{email}/{password}";
                    RestTemplate rt = new RestTemplate();
                    rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                    Map<String, Object> params = new HashMap<>();

                    Log.d("login ##########",""+Userlogin);
                    params.put("loginPrevious", Userlogin);
                    params.put("login", login.getText());
                    params.put("firstname", first_name.getText());
                    params.put("lastname", last_name.getText());
                    params.put("email", email.getText());
                    params.put("password", "123");

                    ResponseRegist ro = rt.getForObject(apiUrl,ResponseRegist.class,params);
                    return ro;
                }catch(Exception ex){
                    Log.e("###################",ex.getMessage());
                }
                return null;
            }
            protected void onPostExecute(ResponseRegist ro){
                super.onPostExecute(ro);
                try{
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(getApplicationContext(), ro.getMessage(), duration);
                    toast.show();

                }catch (Exception e){
                    Log.i("",e.getMessage());
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(getApplicationContext(), "fail to modify", duration);
                    toast.show();
                }





            }
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
