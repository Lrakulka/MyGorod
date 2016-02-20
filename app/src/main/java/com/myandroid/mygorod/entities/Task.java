package com.myandroid.mygorod.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by asd on 20/02/16.
 */
public class Task implements Serializable {
    private Date date_time;
    private String description;
    private String name;

    public Task(Date date_time, String name, String description) {
        this.date_time = date_time;
        this.description = description;
        this.name = name;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
