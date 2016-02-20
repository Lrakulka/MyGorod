package com.myandroid.mygorod.entities;

import java.io.Serializable;

//for example картошка, буряк, ...
public class Element  implements Serializable {

    private int idElement;
    private String name;
    private String description;

    public Element(int idElement, String name, String description) {
        this.idElement = idElement;
        this.name = name;
        this.description = description;
    }

    public int getIdElement() {
        return idElement;
    }

    public void setIdElement(int idElement) {
        this.idElement = idElement;
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
