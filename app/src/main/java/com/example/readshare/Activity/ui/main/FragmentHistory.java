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

import com.example.readshare.Activity.Acceuil;
import com.example.readshare.Activity.DescriptionLivre;
import com.example.readshare.Model.Historique;
import com.example.readshare.Model.Livre;
import com.example.readshare.Network.HistoriqueService;
import com.example.readshare.Network.RetrofitClient;
import com.example.readshare.R;
import com.example.readshare.descriptionMyBook;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHistory extends Fragment {
    GridView gridView;
    HistoriqueAdapter historiqueAdapter;
    View v;

    long id_user;

    public FragmentHistory(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.historique,container,false);
        gridView=v.findViewById(R.id.gridview);

        HistoriqueService service = RetrofitClient.getClient().create(HistoriqueService.class);

        SharedPreferences prefs = this.getActivity().getSharedPreferences("UserFile", Context.MODE_PRIVATE);
        id_user = prefs.getLong("idUser",0);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<List<Historique>> call = service.getHistorique(id_user);

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");


        call.enqueue(new Callback<List<Historique>>() {

            @Override
            public void onResponse(Call<List<Historique>> call, Response<List<Historique>> response) {
                if (response.isSuccessful()) {

                    List<Historique> historiques = response.body();
                    generateDemandeList(historiques);

                }
            }

            @Override
            public void onFailure(Call<List<Historique>> call, Throwable t) {
                // Toast.makeText(this.getActivity().getBaseContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });



        return v;
    }


    private void generateDemandeList(List<Historique> empDataList) {

        historiqueAdapter = new HistoriqueAdapter(this.getActivity().getBaseContext(),empDataList);


        gridView.setAdapter(historiqueAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Historique historique =empDataList.get(position);

                Log.d("user", historique.getLivre().getUser_actuel().getId()+"" );
                Log.d("user", id_user+"");
                if(id_user == historique.getLivre().getUser_actuel().getId()) {

                    Intent intent = new Intent(v.getContext(), descriptionMyBook.class);
                    intent.putExtra("livreId", historique.getLivre().getId()+"");
                    startActivity(intent);
                }

                else {
                    Intent intent = new Intent(v.getContext(), DescriptionLivre.class);
                    intent.putExtra("livreId", historique.getLivre().getId()+"");
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }




}
