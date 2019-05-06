package com.fastspring.pizza.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fastspring.pizza.api.data.entity.Cart;
import com.fastspring.pizza.api.data.entity.Pizza;
import com.fastspring.pizza.api.data.repo.PizzaRepository;
import com.fastspring.pizza.api.data.repo.ShoppingCartRepository;

/*
 * Manages Shopping Cart
 */
public class ShoppingCartController {
	
	@Autowired
    private ShoppingCartRepository cartRepository;
	
	@Autowired
	PizzaRepository pizzaRepository;
	

    @GetMapping("/api/cart/{customerId}")
    public List<Pizza> getAllPizzas(@PathVariable("customerId") int id) {
        
        return cartRepository.getOne(id).getPizzas();
    }
    
	
	@GetMapping("/api/cart/total/{customerId}")
	public Double showCartTotal(@PathVariable("customerId") int id) {
		Cart cart =cartRepository.getOne(id);
		return cart.getTotalPrice();
	}
	
	@DeleteMapping("/api/cart/remove/{toppingId}")
	public void deletePizza
	(@PathVariable("toppingId") int id) {
		pizzaRepository.deleteById(id);
	}

}
