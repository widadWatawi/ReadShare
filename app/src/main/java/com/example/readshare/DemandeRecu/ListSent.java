package com.example.readshare.DemandeRecu;

public class ListSent {
    private String username;
    private String message;
    private int imgId;
    public ListSent(String username,String message, int imgId) {
        this.username = username;
        this.message=message;
        this.imgId = imgId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
