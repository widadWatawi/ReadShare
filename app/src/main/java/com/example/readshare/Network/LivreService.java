package com.example.readshare.Network;

import com.example.readshare.Model.Livre;
import com.example.readshare.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LivreService {

    @GET("api/livres")
    Call<List<Livre>> getLivres();

    @GET("api/livres/{id}")
    Call<Livre> getLivre(@Path("id") Long id);

    @GET("api/livres/genre/{genre}")
    Call<List<Livre>> getLivreParGenre(@Path("genre") String genre);

    @GET("api/best")
    Call<List<Livre>> getBest();

    @GET("api/last")
    Call<List<Livre>> getLast();

    @GET("api/library/{id}")
    Call<List<Livre>> getLibrary(@Path("id") Long id);


    @GET("api/livres/tracabilite/{id}")
    Call<List<User>> getTracabilite(@Path("id") Long id);
}
