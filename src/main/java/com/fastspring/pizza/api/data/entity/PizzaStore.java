package com.fastspring.pizza.api.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="pizzastore")
public class PizzaStore {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy="pizzaStore", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<SiteManager> siteManagers;
	
	public PizzaStore() {
		super();
	}
	
	public PizzaStore(String name) {
		super();
		this.name = name;
	}
	
	public PizzaStore(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}	
