package com.welcometodannyland.pizza.controller;

import com.welcometodannyland.pizza.entity.Pizza;
import com.welcometodannyland.pizza.service.PizzaCommandService;
import com.welcometodannyland.pizza.service.PizzaQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {

    private final PizzaQueryService queryService;
    private final PizzaCommandService commandService;


    public PizzaController(PizzaQueryService queryService, PizzaCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<Pizza> getAllPizzas() {
        return queryService.getAllPizzas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPizza(@RequestBody Pizza pizza) {
        commandService.createPizza(pizza);
    }
}
