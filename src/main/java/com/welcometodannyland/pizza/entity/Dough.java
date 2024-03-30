package com.welcometodannyland.pizza.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Dough {

    @Id
    @GeneratedValue()
    private long doughId;
    private String doughType;

    public String getDoughType() {
        return doughType;
    }

    public void setDoughType(String doughType) {
        this.doughType = doughType;
    }

    public long getDoughId() {
        return doughId;
    }
}
