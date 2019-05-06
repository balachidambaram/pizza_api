/**
 * 
 */
package com.fastspring.pizza.api.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastspring.pizza.api.data.entity.Pizza;

/**
 * @author balac
 *
 */
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

}
