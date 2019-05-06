package com.fastspring.pizza.api.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastspring.pizza.api.data.entity.Topping;

@Repository
public interface ToppingsRepository extends JpaRepository<Topping, Integer>{

	
}
