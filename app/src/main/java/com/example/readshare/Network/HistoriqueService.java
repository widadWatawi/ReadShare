package com.example.readshare.Network;

import com.example.readshare.Model.Demande;
import com.example.readshare.Model.Historique;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HistoriqueService {

    @GET("historique/1")
    Call<List<Historique>> getHistorique();
}
