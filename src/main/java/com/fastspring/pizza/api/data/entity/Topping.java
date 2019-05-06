package com.fastspring.pizza.api.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Topping implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	
	  @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	private String name = "";
	
	private int quantity;
	
	private double rate = 0;
	public void set(Topping newTopping) {
		
	}

}
