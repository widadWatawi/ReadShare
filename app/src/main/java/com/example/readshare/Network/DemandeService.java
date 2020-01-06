package com.example.readshare.Network;

import com.example.readshare.Model.Demande;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DemandeService {

    @GET("demande/{id}/recu")
    Call<List<Demande>> getDemandesRecues(@Path("id") Long id);

    @GET("demande/{id}/envoye")
    Call<List<Demande>> getDemandesEnvoyes(@Path("id") Long id);
}
