package com.example.readshare.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Livre {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("titre")
    @Expose
    private String titre;

    @SerializedName("auteur")
    @Expose
    private String auteur;

    @SerializedName("description")
    @Expose
    private String description;


    @SerializedName("genre")
    @Expose
    private String genre;

    @SerializedName("date")
    @Expose
    private Date date;

    @SerializedName("user_actuel")
    @Expose
    private User user_actuel;

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

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser_actuel() {
        return user_actuel;
    }

    public void setUser_actuel(User user_actuel) {
        this.user_actuel = user_actuel;
    }
}
