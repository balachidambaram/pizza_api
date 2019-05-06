package com.fastspring.pizza.api.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	@OneToOne
    @JoinColumn(name="STORE_ID")
	
	private PizzaStore store;
	@OneToOne
    @JoinColumn(name="CUSTOMER_ID")
	
	private Customer customer;
	
	private double totalPrice;
	
	@OneToMany(mappedBy = "cart", orphanRemoval=true)
	private List<Pizza> pizzas;

	public Cart() {
		super();
	}
	
	public Cart(PizzaStore store, Customer customer) {
		super();
		this.store = store;
		this.customer = customer;
	}
	
	public Cart(PizzaStore store, Customer customer, double totalPrice) {
		super();
		this.store = store;
		this.customer = customer;
		this.totalPrice = totalPrice;
	}
	
	public Cart(PizzaStore store, Customer customer, double totalPrice, List<Pizza> pizzas) {
		super();
		this.store = store;
		this.customer = customer;
		this.totalPrice = totalPrice;
		this.pizzas = pizzas;
	}
	
	public Cart(int id, PizzaStore store, Customer customer, double totalPrice, List<Pizza> pizzas) {
		super();
		this.id = id;
		this.store = store;
		this.customer = customer;
		this.totalPrice = totalPrice;
		this.pizzas = pizzas;
	}
	
	
	public void addPizza(Pizza pizza) {
		if(pizzas == null)
			pizzas = new ArrayList<Pizza>();
		pizzas.add(pizza);
	}
	
	
	public void set(Cart cart) {
		this.store = cart.store != null ? cart.store : this.store;
		this.customer = cart.customer != null ? cart.customer : this.customer;
		this.totalPrice = (Double) cart.totalPrice != null ? cart.totalPrice : this.totalPrice;
		this.pizzas = cart.pizzas != null ? cart.pizzas : this.pizzas;
	}
}
