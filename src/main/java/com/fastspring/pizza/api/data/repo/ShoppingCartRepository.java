package com.fastspring.pizza.api.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastspring.pizza.api.data.entity.Cart;

public interface ShoppingCartRepository extends JpaRepository<Cart, Integer> {

}
