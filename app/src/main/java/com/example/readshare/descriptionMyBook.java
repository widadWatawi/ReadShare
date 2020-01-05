package com.example.readshare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.readshare.Activity.Acceuil;
import com.example.readshare.Activity.DescriptionLivre;
import com.example.readshare.Activity.MainActivity;
import com.example.readshare.Activity.RechercheLivre.MyMenu;
import com.example.readshare.Activity.Tracabilite.DemanderLivre;
import com.example.readshare.Model.Livre;
import com.example.readshare.Network.LivreService;
import com.example.readshare.Network.RetrofitClient;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class descriptionMyBook extends AppCompatActivity {


    Button btnModify , btnDelete, btnTracabilite;
    LinearLayout image;


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


    Boolean IsFavoris = false;
    long id_livre;
    Livre livre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_my_book);

        btnModify = findViewById(R.id.Modify);
        btnDelete = findViewById(R.id.Delete);
        btnTracabilite = findViewById(R.id.Tracabilite);
        image = findViewById(R.id.imageClick);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        id_livre = Long.parseLong(intent.getStringExtra("livreId"));

        LivreService service = RetrofitClient.getClient().create(LivreService.class);

       // Intent intent = getIntent();
        //id_livre = Long.parseLong(intent.getStringExtra("livreId"));

        /*Call the method with parameter in the interface to get the employee data*/
        Call<Livre> call = service.getLivre(id_livre);


        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<Livre>() {

            @Override
            public void onResponse(Call<Livre> call, Response<Livre> response) {
                if (response.isSuccessful()) {
                    livre= response.body();
                    remplir(livre);


                }
            }

            @Override
            public void onFailure(Call<Livre> call, Throwable t) {
                Toast.makeText(descriptionMyBook.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });





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



        btnTracabilite.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent = new Intent(v.getContext(), DemanderLivre.class);
                intent.putExtra("id_livre", id_livre+"");
                //Log.d("livre", id_livre+"");
                startActivity(intent);

            }
        });

        new HttpReqTask3().execute();
        if(IsFavoris){
            ImageView layout=findViewById(R.id.heart_icon); //get the layout object.
            layout.setImageResource (R.drawable.ic_favorite);
        }else{
            ImageView layout=findViewById(R.id.heart_icon); //get the layout object.
            layout.setImageResource (R.drawable.ic_favorite_border);
        }

        image.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                new HttpReqTask2().execute();
                new HttpReqTask3().execute();

            }
        });
    }
    public class HttpReqTask extends AsyncTask<Void,Void, ResponseAuth> {




        @SuppressLint("WrongThread")
        @Override
        protected ResponseAuth doInBackground(Void... voids) {



            try{

                String apiUrl = "http://192.168.1.107:8081/api/deleteBook/{id}";
                RestTemplate rt = new RestTemplate();
                rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Map<String, Object> params = new HashMap<>();

                params.put("id", id_livre);

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
    class HttpReqTask2 extends AsyncTask<Void, Void, ResponseRegist> {

        @SuppressLint("WrongThread")
        @Override
        protected ResponseRegist doInBackground(Void... voids) {

            try{

                String apiUrl = "http://192.168.1.107:8081/Favoris/addFavoris/{idUser}/{idLivre}";
                RestTemplate rt = new RestTemplate();
                rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Map<String, Object> params = new HashMap<>();

                //id a recuperer

                params.put("idLivre", 18);

                SharedPreferences prefs = getSharedPreferences("UserFile",Context.MODE_PRIVATE);
                long id = prefs.getLong("idUser",0);
                params.put("idUser", id);


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
    class HttpReqTask3 extends AsyncTask<Void, Void, ResponseRegist> {

        @SuppressLint("WrongThread")
        @Override
        protected ResponseRegist doInBackground(Void... voids) {

            try{

                String apiUrl = "http://192.168.1.107:8081/Favoris/IsFavoris/{idUser}/{idLivre}";
                RestTemplate rt = new RestTemplate();
                rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Map<String, Object> params = new HashMap<>();

                //id a recuperer

                params.put("idLivre", 18);

                SharedPreferences prefs = getSharedPreferences("UserFile",Context.MODE_PRIVATE);
                long id = prefs.getLong("idUser",0);
                params.put("idUser", id);


                ResponseRegist rr = rt.getForObject(apiUrl,ResponseRegist.class,params);
                return rr;


            }catch(Exception ex){
                Log.e("#############",ex.getMessage());
            }
            return null;
        }

        protected void onPostExecute(ResponseRegist rr){
            super.onPostExecute(rr);
            IsFavoris = rr.getSuccess();
            if(IsFavoris){
                ImageView layout=findViewById(R.id.heart_icon); //get the layout object.
                layout.setImageResource (R.drawable.ic_favorite);
            }else{
                ImageView layout=findViewById(R.id.heart_icon); //get the layout object.
                layout.setImageResource (R.drawable.ic_favorite_border);
            }

        }


    }

    private void remplir(Livre livre){

        titre.setText(livre.getTitre());
        auteur.setText(livre.getAuteur());
        genre.setText(livre.getGenre());
        date.setText(DateFormat.getDateInstance(DateFormat.SHORT).format(livre.getDate()));
        distance.setText("200m");
        description.setText(livre.getDescription());


    }

}
