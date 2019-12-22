package com.example.readshare.Activity.ui.main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.Activity.AjouterLivre;
import com.example.readshare.Activity.Library;
import com.example.readshare.Activity.ModifierLivre;
import com.example.readshare.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

public class  FragmentLibrary extends Fragment {
    public FragmentLibrary(){

    }
    GridView gridView;
    String[] values={"Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7","Person 8", "Person 9", "Person 10", "Person 11", "Person 12", "Person 13", "Person 14"};
    int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7,R.drawable.img3, R.drawable.img4, R.drawable.img1, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img5};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.biblio, container, false);
        gridView=v.findViewById(R.id.gridview);
        LibraryAdapter libraryAdapter=new LibraryAdapter(this.getActivity().getBaseContext(),values,images);
        gridView.setAdapter(libraryAdapter);
        FloatingActionButton btnajouter = v.findViewById(R.id.btnajouter);

        btnajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), AjouterLivre.class);
                view.getContext().startActivity(intent);
            }
        });
        FloatingActionButton btnediter = v.findViewById(R.id.btnaediter);

        btnediter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), ModifierLivre.class);
                startActivity(intent);
            }
        });

        FloatingActionButton btnasupprimer = v.findViewById(R.id.btnsupprimer);

        btnasupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return v;

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}

