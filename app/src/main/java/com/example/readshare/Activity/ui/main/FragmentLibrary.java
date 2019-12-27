package com.example.readshare.Activity.ui.main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.example.readshare.Model.Historique;
import com.example.readshare.Model.Livre;
import com.example.readshare.Network.HistoriqueService;
import com.example.readshare.Network.LivreService;
import com.example.readshare.Network.RetrofitClient;
import com.example.readshare.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  FragmentLibrary extends Fragment {

    GridView gridView;
    LibraryAdapter livreAdapter;
    View v;
    public FragmentLibrary(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.biblio, container, false);
        gridView=v.findViewById(R.id.gridview);

        LivreService service = RetrofitClient.getClient().create(LivreService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<List<Livre>> call = service.getLibrary();

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");


        call.enqueue(new Callback<List<Livre>>() {

            @Override
            public void onResponse(Call<List<Livre>> call, Response<List<Livre>> response) {
                Log.d("widad","widad");
                if (response.isSuccessful()) {

                    List<Livre> library = response.body();
                    generateDemandeList(library);

                }
            }

            @Override
            public void onFailure(Call<List<Livre>> call, Throwable t) {
                // Toast.makeText(this.getActivity().getBaseContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });



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

    private void generateDemandeList(List<Livre> empDataList) {

        livreAdapter = new LibraryAdapter(this.getActivity().getBaseContext(),empDataList);

        gridView.setAdapter(livreAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}

