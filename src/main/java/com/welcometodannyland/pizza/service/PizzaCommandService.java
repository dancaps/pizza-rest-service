package com.welcometodannyland.pizza.service;

import com.welcometodannyland.pizza.entity.Pizza;
import com.welcometodannyland.pizza.repository.PizzaRepository;
import org.springframework.stereotype.Service;

@Service
public class PizzaCommandService {

    PizzaRepository repository;

    public PizzaCommandService(PizzaRepository repository) {
        this.repository = repository;
    }

    public void createPizza(Pizza pizza) {
        repository.save(pizza);
    }
}
