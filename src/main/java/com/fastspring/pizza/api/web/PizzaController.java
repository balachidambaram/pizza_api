package com.fastspring.pizza.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastspring.pizza.api.data.entity.Base;
import com.fastspring.pizza.api.data.entity.Cheese;
import com.fastspring.pizza.api.data.entity.Pizza;
import com.fastspring.pizza.api.data.entity.PizzaSize;
import com.fastspring.pizza.api.data.entity.Sauce;
import com.fastspring.pizza.api.data.repo.BaseRepository;
import com.fastspring.pizza.api.data.repo.CheeseRepository;
import com.fastspring.pizza.api.data.repo.PizzaRepository;
import com.fastspring.pizza.api.data.repo.SauceRepository;
import com.fastspring.pizza.api.data.repo.SizeRepository;

/**
 * 
 * @author Bala Chidambaram
 *
 */
@RestController
public class PizzaController {

	@Autowired
	PizzaRepository pizzaRepository;
	@Autowired
	BaseRepository baseRepository;
	@Autowired
	SizeRepository sizeRepository;
	@Autowired
	CheeseRepository cheeseRepository;
	@Autowired
	SauceRepository sauceRepository;
	

	@PostMapping("/fastspring/pizza/create")
	public ResponseEntity<Pizza> createOrUpdatePizza(@RequestBody Pizza pizza) {
		Pizza newpizza= pizzaRepository.save(pizza);
		return new ResponseEntity<Pizza>(newpizza, HttpStatus.OK);
	}

	@GetMapping("/fastspring/pizzas")
	public Iterable<Pizza> findAllPizzas() {
		return pizzaRepository.findAll();
	}

	@GetMapping("/fastspring/pizza/{pizzaId}")
	public Pizza findPizzaById(
			@PathVariable("pizzaId") int id) {
		return pizzaRepository.getOne(id);
	}

	@PutMapping("/fastspring/pizza/{pizzaId}")
	public ResponseEntity<Pizza> updatePizza(
			@PathVariable("pizzaId") int id,
			@RequestBody Pizza newPizza) {
		Pizza pizza = pizzaRepository.getOne(id);
		if(pizza!=null)
			pizza=pizzaRepository.save(newPizza);
		return new ResponseEntity<Pizza>(pizza, HttpStatus.OK);
	}

	// size
	@PutMapping("/fastspring/pizza/{pizzaId}/size/{sizeId}")
	public Pizza addPizzaSize(
			@PathVariable("pizzaId") int id,
			@PathVariable("sizeId") int sId) {
		Pizza pizza = pizzaRepository.getOne(id);
		PizzaSize pizzaSize = sizeRepository.getOne(sId);
		int quantity = pizzaSize.getQuantity();
		if(quantity > 0) {
			pizza.setPizzaSize(pizzaSize);
			pizzaSize.setQuantity(quantity-1);
			sizeRepository.save(pizzaSize);
		}
		return pizzaRepository.save(pizza);
	}

	// cheese
	@PutMapping("/fastspring/pizza/{pizzaId}/cheese/{cheeseId}")
	public Pizza addPizzaCheese(
			@PathVariable("pizzaId") int id,
			@PathVariable("cheeseId") int cId) {
		Pizza pizza = pizzaRepository.getOne(id);
		Cheese cheese = cheeseRepository.getOne(cId);
		int quantity = cheese.getQuantity();
		if(quantity > 0) {
			pizza.setCheese(cheese);
			cheese.setQuantity(quantity-1);
			cheeseRepository.save(cheese);
		}
		return pizzaRepository.save(pizza);
	}

	// base
	@PutMapping("/fastspring/pizza/{pizzaId}/base/{baseId}")
	public Pizza addPizzaBase(
			@PathVariable("pizzaId") int id,
			@PathVariable("baseId") int bId) {
		Pizza pizza = pizzaRepository.getOne(id);
		Base base = baseRepository.getOne(bId);
		int quantity = base.getQuantity();
		if(quantity > 0) {
			pizza.setBase(base);
			base.setQuantity(quantity-1);
			baseRepository.save(base);
		}
		return pizzaRepository.save(pizza);
	}
	
	//sauce
	@PutMapping("/fastspring/pizza/{pizzaId}/sauce/{sauceId}")
	public Pizza addPizzaSauce(
			@PathVariable("pizzaId") int id,
			@PathVariable("sauceId") int sId) {
		Pizza pizza = pizzaRepository.getOne(id);
		Sauce sauce = sauceRepository.getOne(sId);
		int quantity = sauce.getQuantity();
		if(quantity > 0) {
			pizza.setSauce(sauce);
			sauce.setQuantity(quantity-1);
			sauceRepository.save(sauce);
		}
		return pizzaRepository.save(pizza);
	}
	
	@DeleteMapping("/fastspring/pizza/{pizzaId}")
	public void deletePizza
	(@PathVariable("pizzaId") int id) {
		Pizza pizza = pizzaRepository.getOne(id);
		pizzaRepository.delete(pizza);
	}

	
      
    
}
