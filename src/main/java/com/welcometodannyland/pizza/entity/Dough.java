package com.welcometodannyland.pizza.entity;

import jakarta.persistence.*;

@Entity(name = "Dough")
@Table(name = "dough")
public class Dough {

    @Id
    @SequenceGenerator(name = "dough_id",
            sequenceName = "dough_id",
            allocationSize = 1)
    @GeneratedValue(generator = "dough_id")
    @Column(name = "dough_id",
            updatable = false)
    private Integer doughId;

    @Column(name = "dough_type",
        unique = true,
        nullable = false)
    private String doughType;

    public Dough() {
    }

    public Dough(String doughType) {
        this.doughType = doughType;
    }

    public long getDoughId() {
        return doughId;
    }

    public String getDoughType() {
        return doughType;
    }

    public void setDoughType(String doughType) {
        this.doughType = doughType;
    }
}
