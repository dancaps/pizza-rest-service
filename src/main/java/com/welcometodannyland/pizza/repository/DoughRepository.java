package com.welcometodannyland.pizza.repository;

import com.welcometodannyland.pizza.entity.Dough;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoughRepository extends JpaRepository<Dough, Integer> { }
