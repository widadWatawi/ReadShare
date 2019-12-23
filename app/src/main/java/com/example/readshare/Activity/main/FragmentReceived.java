package com.example.readshare.Activity.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.Activity.DemandeLivre.DemanderLivre;
import com.example.readshare.Activity.DemandeLivre.demandeLivreAdapter;
import com.example.readshare.Model.Demande;
import com.example.readshare.Model.Employee;
import com.example.readshare.Model.Livre;
import com.example.readshare.Network.DemandeService;
import com.example.readshare.Network.GetEmployeeDataService;
import com.example.readshare.Network.LivreService;
import com.example.readshare.Network.RetrofitClient;
import com.example.readshare.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentReceived extends Fragment {

    RecyclerView recyclerView;
    ReceivedAdapter adapter;

    View v;

    public FragmentReceived(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       v= inflater.inflate(R.layout.demande_recu,container,false);
        /*Create handle for the RetrofitInstance interface*/
        DemandeService service = RetrofitClient.getClient().create(DemandeService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<List<Demande>> call = service.getDemandesRecues();

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");


        call.enqueue(new Callback<List<Demande>>() {

            @Override
            public void onResponse(Call<List<Demande>> call, Response<List<Demande>> response) {
                Log.d("widad","widad");
                if (response.isSuccessful()) {

                    List<Demande> demandes = response.body();
                    generateDemandeList(demandes);
                }
            }

            @Override
            public void onFailure(Call<List<Demande>> call, Throwable t) {
              // Toast.makeText(this.getActivity().getBaseContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });


        return v;


    }

    private void generateDemandeList(List<Demande> empDataList) {
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);


        adapter = new ReceivedAdapter(empDataList);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity().getBaseContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

}
