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
import com.example.api.model.Restaurant;
import com.example.api.repository.RestaurantRepository;

@RestController
@RequestMapping("/api/mrc")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	//get all customer REST api
	@GetMapping("/restaurant")
	public List<Restaurant> getAllRestaurant() {
		return restaurantRepository.findAll();
	}
	
	//create customer
	@PostMapping("/restaurant")
	public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	
	//get one customer REST api
	@GetMapping("/restaurant/{id}")
	public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
		Restaurant restaurant = restaurantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id : "+ id));
		return ResponseEntity.ok(restaurant);
	}
	
	//update REST api
	@PutMapping("/restaurant/{id}")
	public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id,@RequestBody Restaurant restaurantDetails) {
		Restaurant restaurant = restaurantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id : "+ id));
		
		restaurant.setLibRestaurant(restaurantDetails.getLibRestaurant());
		restaurant.setLocalisation(restaurantDetails.getLocalisation());
		
		Restaurant updateRestaurant = restaurantRepository.save(restaurant);
		return ResponseEntity.ok(updateRestaurant);
	}

	//delete REST api
	@DeleteMapping("/restaurant/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRestaurant(@PathVariable Long id) {
		Restaurant restaurant = restaurantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id : "+ id));
		
		restaurantRepository.delete(restaurant);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
