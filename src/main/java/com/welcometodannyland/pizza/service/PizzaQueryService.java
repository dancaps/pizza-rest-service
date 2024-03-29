package com.welcometodannyland.pizza.service;

import com.welcometodannyland.pizza.dto.PizzaDto;
import com.welcometodannyland.pizza.entity.Pizza;
import com.welcometodannyland.pizza.repository.PizzaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaQueryService {

    PizzaRepository repository;
    ModelMapper mapper = new ModelMapper();

    public PizzaQueryService(PizzaRepository repository) {
        this.repository = repository;
    }

    public List<Pizza> getAllPizzas() {
        return repository.findAll();
    }

    public PizzaDto getPizza(int id) {
        return mapper.map(repository.getReferenceById(id), PizzaDto.class);
    }
}
