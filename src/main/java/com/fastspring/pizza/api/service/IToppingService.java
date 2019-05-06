package com.fastspring.pizza.api.service;

import java.util.List;

import com.fastspring.pizza.api.data.entity.Topping;

public interface IToppingService {
	
	List<Topping> getAllToppings();

	Topping findOne(int id);

	Topping save(Topping topping);

	void delete(int id);

}
