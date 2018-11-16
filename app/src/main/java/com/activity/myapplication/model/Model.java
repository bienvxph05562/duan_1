package com.activity.myapplication.model;

public class Model {


    private int image ;
    private String tvName, tvNd ;

    public Model(int image, String tvName, String tvNd) {
        this.image = image;
        this.tvName = tvName;
        this.tvNd = tvNd;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getTvNd() {
        return tvNd;
    }

    public void setTvNd(String tvNd) {
        this.tvNd = tvNd;
    }
}
