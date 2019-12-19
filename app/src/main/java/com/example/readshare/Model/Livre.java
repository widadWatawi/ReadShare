package com.example.readshare.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Livre {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("titre")
    @Expose
    private String titre;


    public Livre() {
    }

    public Livre(Long id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
