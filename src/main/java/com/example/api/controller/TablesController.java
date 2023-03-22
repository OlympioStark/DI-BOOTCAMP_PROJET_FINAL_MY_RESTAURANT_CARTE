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
import com.example.api.model.Tables;
import com.example.api.repository.TablesRepository;

@RestController
@RequestMapping("/api/mrc/tab")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class TablesController {
	
	@Autowired
	private TablesRepository tablesRepository;
	
	//get all customer REST api
	@GetMapping("/tables")
	public List<Tables> getAllUsers() {
		return tablesRepository.findAll();
	}
	
	//create customer
	@PostMapping("/tables")
	public Tables createTables(@RequestBody Tables tables) {
		return tablesRepository.save(tables);
	}
	
	//get one customer REST api
	@GetMapping("/tables/{id}")
	public ResponseEntity<Tables> getTables(@PathVariable Long id) {
		Tables tables = tablesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Table not exist with id : "+ id));
		return ResponseEntity.ok(tables);
	}
	
	//update REST api
	@PutMapping("/tables/{id}")
	public ResponseEntity<Tables> updateTables(@PathVariable Long id,@RequestBody Tables tablesDetails) {
		Tables tables = tablesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Table not exist with id : "+ id));
		
		tables.setNumTable(tablesDetails.getNumTable());
		tables.setNbPlaces(tablesDetails.getNbPlaces());
		tables.setLocation(tablesDetails.getLocation());
		
		Tables updateTables = tablesRepository.save(tables);
		return ResponseEntity.ok(updateTables);
	}

	//delete REST api
	@DeleteMapping("/tables/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTables(@PathVariable Long id) {
		Tables tables = tablesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Table not exist with id : "+ id));
		
		tablesRepository.delete(tables);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
