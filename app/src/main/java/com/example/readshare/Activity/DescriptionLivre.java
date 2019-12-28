package com.example.readshare.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.readshare.Activity.DemandeLivre.DemanderLivre;
import com.example.readshare.Model.Livre;
import com.example.readshare.Network.LivreService;
import com.example.readshare.Network.RetrofitClient;
import com.example.readshare.R;

import java.text.DateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DescriptionLivre  extends AppCompatActivity {


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

    Livre livre;
    Long id_livre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_livre);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        id_livre = Long.parseLong(intent.getStringExtra("livreId"));

        LivreService service = RetrofitClient.getClient().create(LivreService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<Livre> call = service.getLivre(id_livre);
        id_livre = (long)0;


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
                Toast.makeText(DescriptionLivre.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });



        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Profile.class);
                startActivity(intent);
            }
        });

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
