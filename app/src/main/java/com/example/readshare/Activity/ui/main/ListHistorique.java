package com.example.readshare.Activity.ui.main;

public class ListHistorique {
    private String title;
    private int image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ListHistorique(int image, String title){
        this.image=image;
        this.title=title;
    }
}
