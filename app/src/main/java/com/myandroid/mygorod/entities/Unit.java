package com.myandroid.mygorod.entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by asd on 20/02/16.
 */
public class Unit implements Serializable {
    private Integer x;
    private Integer y;
    private Integer weight;
    private Integer height;
    private Element element;
    private ArrayList<Task> tasks;

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Unit(Integer x, Integer y, Integer weight, Integer height, Element element, ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.height = height;
        this.element = element;
    }

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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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

}
