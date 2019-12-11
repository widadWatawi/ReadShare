package com.example.readshare.DemandeLivre;

class ListDemandeLivre {
    private String titre;
    private String distance;
    private int imgId;
    public ListDemandeLivre(String titre,String distance, int imgId) {
        this.titre = titre;
        this.distance=distance;
        this.imgId = imgId;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public int getImgId() {
        return imgId;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
