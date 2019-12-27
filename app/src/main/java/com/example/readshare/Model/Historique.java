package com.example.readshare.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Historique {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("livre")
    @Expose
    private Livre livre;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }
}
