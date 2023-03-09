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
import com.example.api.model.Carte;
import com.example.api.repository.CarteRepository;

@RestController
@RequestMapping("/api/mrc")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CarteController {
	
	@Autowired
	private CarteRepository carteRepository;
	
	//get all customer REST api
	@GetMapping("/carte")
	public List<Carte> getAllUsers() {
		return carteRepository.findAll();
	}
	
	//create customer
	@PostMapping("/carte")
	public Carte createCarte(@RequestBody Carte carte) {
		return carteRepository.save(carte);
	}
	
	//get one customer REST api
	@GetMapping("/carte/{id}")
	public ResponseEntity<Carte> getCarte(@PathVariable Long id) {
		Carte carte = carteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Carte not exist with id : "+ id));
		return ResponseEntity.ok(carte);
	}
	
	//update REST api
	@PutMapping("/carte/{id}")
	public ResponseEntity<Carte> updateCarte(@PathVariable Long id,@RequestBody Carte carteDetails) {
		Carte carte = carteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Carte not exist with id : "+ id));
		
		carte.setLibCarte(carteDetails.getLibCarte());
		
		Carte updateCarte = carteRepository.save(carte);
		return ResponseEntity.ok(updateCarte);
	}

	//delete REST api
	@DeleteMapping("/carte/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCarte(@PathVariable Long id) {
		Carte carte = carteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Carte not exist with id : "+ id));
		
		carteRepository.delete(carte);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}


}
