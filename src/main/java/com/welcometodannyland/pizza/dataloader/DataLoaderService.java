package com.welcometodannyland.pizza.dataloader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.welcometodannyland.pizza.repository.DoughRepository;
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
    private final PizzaRepository pizzaRepository;
    private final DoughRepository doughRepository;
    private final ObjectMapper objectMapper;

    public DataLoaderService(PizzaRepository pizzaRepository, DoughRepository doughRepository, ObjectMapper objectMapper) {
        this.pizzaRepository = pizzaRepository;
        this.doughRepository = doughRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) {
        loadPizzaTable();
        loadDoughTable();
    }

    private void loadPizzaTable() {
        if(pizzaRepository.findAll().isEmpty()) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/pizzas.json")) {
                Pizzas allPizzas = objectMapper.readValue(inputStream, Pizzas.class);
                log.info("==> Reading {} pizzas from the data file and saving it to the database.", allPizzas.pizzas().size());
                pizzaRepository.saveAll(allPizzas.pizzas());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("==> There are pizzas in the database. Skipping data loader for the pizza table.");
        }
    }

    private void loadDoughTable() {
        if(doughRepository.findAll().isEmpty()) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/doughs.json")) {
                Doughs allDoughs = objectMapper.readValue(inputStream, Doughs.class);
                log.info("==> Reading {} dough types from the data file and saving it to the database.", allDoughs.doughs().size());
                doughRepository.saveAll(allDoughs.doughs());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data for dough types", e);
            }
        } else {
            log.info("==> There is dough in the database. Skipping data loader for the dough table.");
        }
    }
}
