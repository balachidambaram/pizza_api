package com.fastspring.pizza.api.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {
	
	@Column(name="CUSTOMER_ID")
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customerId;
	

}
