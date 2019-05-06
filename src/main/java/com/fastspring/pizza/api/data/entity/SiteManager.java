package com.fastspring.pizza.api.data.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="sitemanager")
public class SiteManager extends User {

	
	private String key;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pizzastore_id" ,referencedColumnName="id",nullable=false,unique=true)
	@JsonIgnore
	private PizzaStore pizzaStore;

	public void populateSiteManager(SiteManager newSiteManager) {
		this.key=newSiteManager.key;
		this.pizzaStore=newSiteManager.pizzaStore;
		
		
	}

	
	}
