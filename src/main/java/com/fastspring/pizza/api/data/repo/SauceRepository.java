package com.fastspring.pizza.api.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastspring.pizza.api.data.entity.Sauce;

public interface SauceRepository extends JpaRepository<Sauce, Integer> {

}
