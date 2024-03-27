package com.welcometodannyland.pizza.service;

import com.welcometodannyland.pizza.entity.Pizza;
import com.welcometodannyland.pizza.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaQueryService {

    PizzaRepository repository;

    public PizzaQueryService(PizzaRepository repository) {
        this.repository = repository;
    }

    public List<Pizza> getAllPizzas() {
        return repository.findAll();
    }
}
