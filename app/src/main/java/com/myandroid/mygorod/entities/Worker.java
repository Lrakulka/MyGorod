package com.myandroid.mygorod.entities;

import java.io.Serializable;

/**
 * Created by asd on 20/02/16.
 */
public class Worker implements Serializable {
    private String id;
    private Garden garden;

    public Worker(String id, Garden garden) {
        this.id = id;
        this.garden = garden;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Garden getGarden() {
        return garden;
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
    }
}
