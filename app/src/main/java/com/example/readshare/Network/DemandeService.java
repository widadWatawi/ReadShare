package com.example.readshare.Network;

import com.example.readshare.Model.Demande;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DemandeService {

    @GET("demande/1/recu")
    Call<List<Demande>> getDemandesRecues();

    @GET("demande/2/envoye")
    Call<List<Demande>> getDemandesEnvoyes();
}
