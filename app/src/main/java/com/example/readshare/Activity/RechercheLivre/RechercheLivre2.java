package com.example.readshare.Activity.RechercheLivre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.readshare.Activity.LivrePropose.DemanderLivre;
import com.example.readshare.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RechercheLivre2 extends AppCompatActivity {

    @BindView(R.id.romance)
    Button romance;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_livre2);
        ButterKnife.bind(this);

        romance = findViewById(R.id.romance);

    }

    @OnClick(R.id.romance)
    public void buttonOneClicked() {
        romance.setBackgroundColor(Color.parseColor("#B0E0E6"));
        Intent intent = new Intent(getApplicationContext(), com.example.readshare.Activity.DemandeLivre.DemanderLivre.class);
        intent.putExtra("genre", "genre1");
        startActivity(intent);


    }

}
