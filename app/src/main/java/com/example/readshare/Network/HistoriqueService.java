package com.example.readshare.Network;

import com.example.readshare.Model.Demande;
import com.example.readshare.Model.Historique;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HistoriqueService {

    @GET("historique/{id}")
    Call<List<Historique>> getHistorique(@Path("id") Long id);
}
