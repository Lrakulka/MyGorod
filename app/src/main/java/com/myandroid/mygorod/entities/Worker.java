package com.myandroid.mygorod.entities;

import java.io.Serializable;

/**
 * Created by asd on 20/02/16.
 */
public class Worker implements Serializable {
    private Integer id;
    private Garden garden;

    public Worker(Integer id, Garden garden) {
        this.id = id;
        this.garden = garden;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Garden getGarden() {
        return garden;
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
    }
}
