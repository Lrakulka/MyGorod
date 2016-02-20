package com.myandroid.mygorod.entities;

import java.io.Serializable;

public class OgorodItem implements Serializable {

    private int idOgorod;
    private String name;
    private String pictureOgorod; //not necessary

    public OgorodItem(int idOgorod, String name, String pictureOgorod) {
        this.idOgorod = idOgorod;
        this.name = name;
        this.pictureOgorod = pictureOgorod;
    }

    public int getIdOgorod() {
        return idOgorod;
    }

    public void setIdOgorod(int idOgorod) {
        this.idOgorod = idOgorod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureOgorod() {
        return pictureOgorod;
    }

    public void setPictureOgorod(String pictureOgorod) {
        this.pictureOgorod = pictureOgorod;
    }
}
