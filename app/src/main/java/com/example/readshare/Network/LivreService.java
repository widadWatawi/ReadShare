package com.example.readshare.Network;

import com.example.readshare.Model.Livre;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LivreService {

    @GET("livres/")
    Call<List<Livre>> getLivres();

    @GET("api/library/1")
    Call<List<Livre>> getLibrary();
}
