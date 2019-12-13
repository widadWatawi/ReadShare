package com.example.readshare.RechercheLivre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.readshare.R;

public class RechercheLivre2 extends AppCompatActivity {

    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_livre2);

        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), MyMenu.class);
                startActivity(intent);
            }
        });
    }
}
