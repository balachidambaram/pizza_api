package com.fastspring.pizza.api.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastspring.pizza.api.data.entity.Cheese;

public interface CheeseRepository extends JpaRepository<Cheese, Integer> {

}
