package com.example.readshare.Network;

import com.example.readshare.Model.Livre;
import com.example.readshare.Model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {

    @GET("rest/users/{id}")
    Call<User> getUser(@Path("id") Long id);
}
