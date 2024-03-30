package com.welcometodannyland.pizza.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Entity
public class Pizza {
        @Id
        @GeneratedValue
        private Integer id;
        private String dough;
        private String sauce;
        private String cheese;
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

        public void setId(Integer id) {
                this.id = id;
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

        @Override
        public String toString() {
                return "Pizza{" +
                        "id=" + id +
                        ", dough='" + dough + '\'' +
                        ", sauce='" + sauce + '\'' +
                        ", cheese='" + cheese + '\'' +
                        ", toppings='" + toppings + '\'' +
                        '}';
        }
}
