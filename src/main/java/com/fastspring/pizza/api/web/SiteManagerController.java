package com.fastspring.pizza.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastspring.pizza.api.data.entity.Cheese;
import com.fastspring.pizza.api.data.entity.PizzaSize;
import com.fastspring.pizza.api.data.entity.PizzaStore;
import com.fastspring.pizza.api.data.entity.Sauce;
import com.fastspring.pizza.api.data.entity.SiteManager;
import com.fastspring.pizza.api.data.repo.BaseRepository;
import com.fastspring.pizza.api.data.repo.CheeseRepository;
import com.fastspring.pizza.api.data.repo.SauceRepository;
import com.fastspring.pizza.api.data.repo.SiteManagerRepository;
import com.fastspring.pizza.api.data.repo.SizeRepository;

/**
 * Manages Store/Site Manager info
 * @author Bala Chidambaram
 *
 */
@RestController
public class SiteManagerController {

	@Autowired
	SiteManagerRepository siteManagerRepository;
	
	@Autowired
	BaseRepository baseRepository;
	@Autowired
	SizeRepository sizeRepository;
	@Autowired
	CheeseRepository cheeseRepository;
	@Autowired
	SauceRepository sauceRepository;
	
	
	/**
	 * Site Manager Can use this service to manage the inventory and price of the Pizza Size
	 * @param pizzaSize
	 * @return
	 */
	// size
	@PutMapping("/fastspring/managesize")
	public PizzaSize managePizzaSize(@RequestBody PizzaSize pizzaSize) {
		PizzaSize newPizzaSize = sizeRepository.getOne(pizzaSize.getId());
		if(newPizzaSize!=null) {
			newPizzaSize.setQuantity(pizzaSize.getQuantity());
			newPizzaSize.setPrice(pizzaSize.getQuantity());
			return sizeRepository.save(pizzaSize);
		}
		return sizeRepository.save(pizzaSize);
	}
	
	/**
	 * Site Manager Can use this service to manage the inventory and price of the Cheese
	 * @param cheese
	 * @return
	 */
	@PutMapping("/fastspring/managecheese")
	public Cheese manageCheese(@RequestBody Cheese cheese) {
		Cheese newCheese = cheeseRepository.getOne(cheese.getId());
		if(newCheese!=null) {
			newCheese.setQuantity(cheese.getQuantity());
			newCheese.setPrice(cheese.getQuantity());
			return cheeseRepository.save(cheese);
		}
		return cheeseRepository.save(cheese);
	}
		
	/**
	 * Site Manager Can use this service to manage the inventory and price of the Pizza Sauce
	 * @param sauce
	 * @return
	 */
	@PutMapping("/fastspring/managesauce")
	public Sauce manageSauce(@RequestBody Sauce sauce) {
		Sauce newSauce = sauceRepository.getOne(sauce.getId());
		if(newSauce!=null) {
			newSauce.setQuantity(sauce.getQuantity());
			newSauce.setPrice(sauce.getQuantity());
			return sauceRepository.save(newSauce);
		}
		return sauceRepository.save(sauce);
	}
		

		
	@PostMapping("/api/siteManager")
	public SiteManager createSiteManager(@RequestBody SiteManager siteManager) {
		return siteManagerRepository.save(siteManager);
	}
	
	@GetMapping("/api/siteManager")
	public Iterable<SiteManager> findAllSiteManagers() {
		return siteManagerRepository.findAll();
	}
	  
	 
	@GetMapping("/api/siteManager/{siteManagerId}")
	public SiteManager findSiteManagerById(
			@PathVariable("siteManagerId") int id) {
		return siteManagerRepository.getOne(id);
	}
	
	@GetMapping("/api/siteManager/{siteManagerId}/store")
	public PizzaStore findStoreByManagerId(
			@PathVariable("siteManagerId") int id) {
		SiteManager sm = siteManagerRepository.getOne(id);
		return sm.getPizzaStore();
	}

	@PutMapping("/api/siteManager/{siteManagerId}")
	public SiteManager updateSiteManager(
			@PathVariable("siteManagerId") int id,
			@RequestBody SiteManager newSiteManager) {
		SiteManager siteManager = siteManagerRepository.getOne(id);
		siteManager.populateSiteManager(newSiteManager);
		return siteManagerRepository.save(siteManager);
	}
	
	
	
	
	
}
	
	
