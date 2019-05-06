package com.fastspring.pizza.api.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="BASE_ID")
	private Base base;
	@OneToOne(cascade=CascadeType.ALL)
	
 /*   @JoinColumn(name="TOPPING_ID")
	private Topping topping;*/
	
    @JoinColumn(name="SAUCE_ID")
	private Sauce sauce;
	
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="CHEESE_ID")
	private Cheese cheese;
	
    @OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="SIZE_ID")
	private PizzaSize pizzaSize;
	
	private double price;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cart_id")
	@JsonIgnore
	
	private Cart cart;

	/*@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="pizza_toppings",
	joinColumns=@JoinColumn(name="PIZZA_ID", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="TOPPING_ID", referencedColumnName="id"))
	List<Topping> toppings;*/

	
	public Pizza(PizzaSize pizzaSize, Base base, Cheese cheese, Sauce sauce) {
		super();
		this.pizzaSize = pizzaSize;
		this.base = base;
		this.cheese = cheese;
		this.sauce = sauce;
	}
	
	
		
}
