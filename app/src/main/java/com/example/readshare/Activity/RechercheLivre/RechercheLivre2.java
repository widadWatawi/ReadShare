package com.example.readshare.Activity.RechercheLivre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.readshare.Activity.LivrePropose.DemanderLivre;
import com.example.readshare.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RechercheLivre2 extends AppCompatActivity {

    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_livre2);
        ButterKnife.bind(this);

        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), DemanderLivre.class);
                startActivity(intent);
            }
        });

    }

    @OnClick(R.id.romance)
    public void buttonOneClicked() {
        Intent intent = new Intent(getApplicationContext(), com.example.readshare.Activity.DemandeLivre.DemanderLivre.class);
        intent.putExtra("genre", "genre1");
        startActivity(intent);

    }

}
