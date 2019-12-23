package com.example.readshare.Activity.ui.main;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readshare.Activity.main.ReceivedAdapter;
import com.example.readshare.Model.Demande;
import com.example.readshare.Model.Historique;
import com.example.readshare.Network.DemandeService;
import com.example.readshare.Network.HistoriqueService;
import com.example.readshare.Network.RetrofitClient;
import com.example.readshare.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHistory extends Fragment {
    GridView gridView;
    HistoriqueAdapter historiqueAdapter;
    View v;

    public FragmentHistory(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.historique,container,false);
        gridView=v.findViewById(R.id.gridview);

        HistoriqueService service = RetrofitClient.getClient().create(HistoriqueService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<List<Historique>> call = service.getHistorique();

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");


        call.enqueue(new Callback<List<Historique>>() {

            @Override
            public void onResponse(Call<List<Historique>> call, Response<List<Historique>> response) {
                Log.d("widad","widad");
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
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}

