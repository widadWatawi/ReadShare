package com.example.readshare.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.readshare.R;

import butterknife.BindView;
import butterknife.ButterKnife;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_livre);
        ButterKnife.bind(this);

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
