package com.fastspring.pizza.api.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastspring.pizza.api.data.entity.PizzaSize;

public interface SizeRepository extends JpaRepository<PizzaSize, Integer> {

}
