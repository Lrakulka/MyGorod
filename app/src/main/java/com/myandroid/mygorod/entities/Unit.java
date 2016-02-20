package com.myandroid.mygorod.entities;

import android.graphics.Bitmap;
import android.graphics.Point;

/**
 * Created by asd on 20/02/16.
 */
public class Unit {
    private Integer x;
    private Integer y;
    private Integer weinght;
    private Integer height;
    private Element element;
    private Garden garden;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getWeinght() {
        return weinght;
    }

    public void setWeinght(Integer weinght) {
        this.weinght = weinght;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Garden getGarden() {
        return garden;
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
    }
}
