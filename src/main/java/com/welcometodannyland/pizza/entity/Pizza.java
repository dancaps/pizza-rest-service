package com.welcometodannyland.pizza.entity;

import jakarta.persistence.*;

@Entity(name = "Pizza")
@Table(name = "pizza")
public class Pizza {

        @Id
        @SequenceGenerator(name = "id",
                sequenceName = "id",
                allocationSize = 1)
        @GeneratedValue(generator = "id")
        @Column(name = "id",
                updatable = false)
        private Integer id;

        @Column(name = "dough",
                nullable = false)
        private String dough;

        @Column(name = "sauce")
        private String sauce;

        @Column(name = "cheese")
        private String cheese;

        @Column(name = "toppings")
        private String toppings;

        public Pizza() {
        }

        public Pizza(String dough, String sauce, String cheese, String toppings) {
                this.dough = dough;
                this.sauce = sauce;
                this.cheese = cheese;
                this.toppings = toppings;
        }

        public Integer getId() {
                return id;
        }

        public String getDough() {
                return dough;
        }

        public void setDough(String dough) {
                this.dough = dough;
        }

        public String getSauce() {
                return sauce;
        }

        public void setSauce(String sauce) {
                this.sauce = sauce;
        }

        public String getCheese() {
                return cheese;
        }

        public void setCheese(String cheese) {
                this.cheese = cheese;
        }

        public String getToppings() {
                return toppings;
        }

        public void setToppings(String toppings) {
                this.toppings = toppings;
        }
}
