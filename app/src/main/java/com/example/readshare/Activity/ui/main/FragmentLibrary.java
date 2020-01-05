package com.example.readshare.Activity.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.readshare.Activity.AjouterLivre;
import com.example.readshare.Activity.DescriptionLivre;
import com.example.readshare.Activity.ModifierLivre;
import com.example.readshare.Model.Livre;
import com.example.readshare.Model.User;
import com.example.readshare.Network.LivreService;
import com.example.readshare.Network.RetrofitClient;
import com.example.readshare.OnItemClickListener;
import com.example.readshare.R;
import com.example.readshare.descriptionMyBook;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentLibrary extends Fragment {
    GridView gridView;
    LibraryAdapter livreAdapter;
    View v;
    User user;
    public FragmentLibrary(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.biblio, container, false);
        gridView=v.findViewById(R.id.gridview);


        SharedPreferences prefs = this.getActivity().getSharedPreferences("UserFile", Context.MODE_PRIVATE);
        long id = prefs.getLong("idUser",0);


        LivreService service = RetrofitClient.getClient().create(LivreService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<List<Livre>> call = service.getLibrary(id);

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
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Livre livre =empDataList.get(position);
                Intent intent = new Intent(v.getContext(), descriptionMyBook.class);
                intent.putExtra("livreId", livre.getId()+"");
                startActivity(intent);
            }
        });




    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }




}
