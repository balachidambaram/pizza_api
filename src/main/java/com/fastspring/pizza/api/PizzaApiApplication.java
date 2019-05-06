package com.fastspring.pizza.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fastspring.pizza.api.data.entity.Topping;
import com.fastspring.pizza.api.data.repo.ToppingsRepository;

@SpringBootApplication
@EnableJpaRepositories("com.fastspring.pizza.api.*")
@ComponentScan(basePackages = { "com.fastspring.pizza.api.*" })
@EntityScan("com.fastspring.pizza.api.*") 
@EnableWebMvc
public class PizzaApiApplication {
	
	private static final Logger log = LoggerFactory.getLogger(PizzaApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PizzaApiApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(ToppingsRepository toppingsRepository) {
		return (args) -> {
			// save a couple of customers
			toppingsRepository.save(new Topping(1,"Onion", 1, 1.0));
			

			// fetch all toppings
			log.info("Toppings found with findAll():");
			log.info("-------------------------------");
			for (Topping topping : toppingsRepository.findAll()) {
				log.info(topping.toString());
			}
			
		};
	}

}
