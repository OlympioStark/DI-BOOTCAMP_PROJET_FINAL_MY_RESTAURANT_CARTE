package com.example.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.exception.ResourceNotFoundException;
import com.example.api.model.Food;
import com.example.api.repository.FoodRepository;


@RestController
@RequestMapping("/api/mrc/fo")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class FoodController {
	
	@Autowired
	private FoodRepository foodRepository;
	
	//get all customer REST api
	@GetMapping("/food")
	public List<Food> getAllUsers() {
		return foodRepository.findAll();
	}
	
	//create customer
	@PostMapping("/food")
	public Food createFood(@RequestBody Food food) {
		return foodRepository.save(food);
	}
	
	//get one customer REST api
	@GetMapping("/food/{id}")
	public ResponseEntity<Food> getFood(@PathVariable Long id) {
		Food food = foodRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Food not exist with id : "+ id));
		return ResponseEntity.ok(food);
	}
	
	//update REST api
	@PutMapping("/food/{id}")
	public ResponseEntity<Food> updateFood(@PathVariable Long id,@RequestBody Food foodDetails) {
		Food food = foodRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Food not exist with id : "+ id));
		
		food.setLibelle(foodDetails.getLibelle());
		food.setPrice(foodDetails.getPrice());
		
		Food updateFood = foodRepository.save(food);
		return ResponseEntity.ok(updateFood);
	}

	//delete REST api
	@DeleteMapping("/food/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteFood(@PathVariable Long id) {
		Food food = foodRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Food not exist with id : "+ id));
		
		foodRepository.delete(food);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
