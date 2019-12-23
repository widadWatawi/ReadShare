package com.example.readshare.Activity.ui.main;

public class ListTracabilite {
    private int img;
    private String distance;

    public ListTracabilite(int img, String distance){
        this.img=img;
        this.distance=distance;
    }

    public void setImg(int img) {
        this.img = img;

    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getImg() {
        return img;
    }

    public String getDistance() {
        return distance;
    }


}
