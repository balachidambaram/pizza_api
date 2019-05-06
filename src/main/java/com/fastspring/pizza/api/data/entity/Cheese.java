package com.fastspring.pizza.api.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cheese implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5936530985679332949L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore 
	private int id;
	@JsonIgnore 
	private String name;
	@JsonIgnore 
	private int quantity;
	@JsonIgnore 
	private double price;

}
