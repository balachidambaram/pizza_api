package com.fastspring.pizza.api.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastspring.pizza.api.data.entity.Topping;
import com.fastspring.pizza.api.service.IToppingService;

@RestController
public class TopingController {
	
	@Autowired
    private IToppingService toppingService;

    @GetMapping("/api/toppings")
    public List<Topping> findToppings() {
        
        return toppingService.getAllToppings();
    }
    

	@GetMapping("/api/topping/{toppingId}")
	public Topping findToppingById(
			@PathVariable("toppingId") int id) {
		return toppingService.findOne(id);
	}

	
	@PutMapping("/api/addtopping/{id}")
    public ResponseEntity<Topping> addTopping(@PathVariable(value = "id") int toppingId, @RequestBody Topping newTopping) {
        final Topping updatedTopping = toppingService.save(newTopping);
		return ResponseEntity.ok(updatedTopping);
    }
	
	@PutMapping("/api/topping/{toppingId}")
	public Topping updateTopping(
			@PathVariable("toppingId") int id,
			@RequestBody Topping newTopping) {
		Topping topping = toppingService.findOne(id);
		topping.set(newTopping);
		return toppingService.save(topping);
	}
	
	@DeleteMapping("/api/topping/{toppingId}")
	public void deleteTopping
	(@PathVariable("toppingId") int id) {
		toppingService.delete(id);
	}
    
    
   

}
