package com.example.readshare.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Demande {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("user_sender")
    @Expose
    private User user_sender;

    @SerializedName("user_receiver")
    @Expose
    private User user_receiver;

    @SerializedName("livre_received")
    @Expose
    private Livre livre_received;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser_sender() {
        return user_sender;
    }

    public void setUser_sender(User user_sender) {
        this.user_sender = user_sender;
    }

    public User getUser_receiver() {
        return user_receiver;
    }

    public void setUser_receiver(User user_receiver) {
        this.user_receiver = user_receiver;
    }

    public Livre getLivre_received() {
        return livre_received;
    }

    public void setLivre_received(Livre livre_received) {
        this.livre_received = livre_received;
    }
}
