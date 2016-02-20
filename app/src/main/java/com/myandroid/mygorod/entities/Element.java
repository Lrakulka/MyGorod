package com.myandroid.mygorod.entities;

import android.graphics.Bitmap;

import java.io.Serializable;

//for example картошка, буряк, ...
public class Element implements Serializable {

    private String color;
    private String name;
    private Bitmap image;
    private String description;

    public Element(String color, String name, Bitmap image, String description) {
        this.color = color;
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
