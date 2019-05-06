package com.fastspring.pizza.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastspring.pizza.api.data.entity.Topping;
import com.fastspring.pizza.api.data.repo.ToppingsRepository;

@Service
public class ToppingService implements IToppingService{
	
	@Autowired
	ToppingsRepository toppingsRepository;
	
	
	public List<Topping> getAllToppings() {
        List<Topping>  toppings = new ArrayList<>();
        toppingsRepository.findAll().forEach(toppings::add);
        return toppings;
    }


	@Override
	public Topping findOne(int id) {
	     return toppingsRepository.getOne(id);
	}


	@Override
	public Topping save(Topping topping) {
		return toppingsRepository.save(topping);
	
	}


	@Override
	public void delete(int id) {
		toppingsRepository.deleteById(id);
	}

	

}
