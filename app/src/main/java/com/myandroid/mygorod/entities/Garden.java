package com.myandroid.mygorod.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by asd on 20/02/16.
 */
public class Garden implements Serializable {
    private String name;
    private Boss boss;
    private double latitude;
    private double longitude;
    private List<Unit> units;

    public Garden(String name, Boss boss, double latitude, double longitude, List<Unit> units) {
        this.name = name;
        this.boss = boss;
        this.latitude = latitude;
        this.longitude = longitude;
        this.units = units;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
