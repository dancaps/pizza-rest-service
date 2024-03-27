package com.welcometodannyland.pizza.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.welcometodannyland.pizza.entity.Pizzas;
import com.welcometodannyland.pizza.repository.PizzaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class DataLoaderService implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(DataLoaderService.class);
    private final PizzaRepository repository;
    private final ObjectMapper objectMapper;
    private final String DATA_PATH = "/data/pizza.json";

    public DataLoaderService(PizzaRepository pizzaRepository, ObjectMapper objectMapper) {
        this.repository = pizzaRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) {
        loadPizzaTable();
    }

    private void loadPizzaTable() {
        if(repository.findAll().isEmpty()) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream(this.DATA_PATH)) {
                Pizzas allPizzas = objectMapper.readValue(inputStream, Pizzas.class);
                log.info("==> Reading {} pizzas from the data file and saving it to the database.", allPizzas.pizzas().size());
                repository.saveAll(allPizzas.pizzas());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("==> There are pizzas in the database. Skipping data loader for the pizza table.");
        }
    }
}
