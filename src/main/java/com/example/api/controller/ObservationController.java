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
import com.example.api.model.Observation;
import com.example.api.repository.ObservationRepository;

@RestController
@RequestMapping("/api/mrc/obs")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ObservationController {
	
	@Autowired
	private ObservationRepository observationRepository;
	
	//get all customer REST api
	@GetMapping("/observation")
	public List<Observation> getAllUsers() {
		return observationRepository.findAll();
	}
	
	//create customer
	@PostMapping("/observation")
	public Observation createObservation(@RequestBody Observation observation) {
		return observationRepository.save(observation);
	}
	
	//get one customer REST api
	@GetMapping("/observation/{id}")
	public ResponseEntity<Observation> getObservation(@PathVariable Long id) {
		Observation observation = observationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Observation not exist with id : "+ id));
		return ResponseEntity.ok(observation);
	}
	
	//update REST api
	@PutMapping("/observation/{id}")
	public ResponseEntity<Observation> updateObservation(@PathVariable Long id,@RequestBody Observation observationDetails) {
		Observation observation = observationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Observation not exist with id : "+ id));
		
		observation.setLibelleObserv(observationDetails.getLibelleObserv());
		
		Observation updateObservation = observationRepository.save(observation);
		return ResponseEntity.ok(updateObservation);
	}

	//delete REST api
	@DeleteMapping("/observation/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteObservation(@PathVariable Long id) {
		Observation observation = observationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Observation not exist with id : "+ id));
		
		observationRepository.delete(observation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
