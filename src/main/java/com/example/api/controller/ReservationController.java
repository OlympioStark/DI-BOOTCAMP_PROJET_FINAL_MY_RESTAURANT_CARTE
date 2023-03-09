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
import com.example.api.model.Reservation;
import com.example.api.repository.ReservationRepository;

@RestController
@RequestMapping("/api/mrc")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ReservationController {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	//get all customer REST api
	@GetMapping("/reservation")
	public List<Reservation> getAllUsers() {
		return reservationRepository.findAll();
	}
	
	//create customer
	@PostMapping("/reservation")
	public Reservation createReservation(@RequestBody Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	//get one customer REST api
	@GetMapping("/reservation/{id}")
	public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
		Reservation reservation = reservationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Reservation not exist with id : "+ id));
		return ResponseEntity.ok(reservation);
	}
	
	//update REST api
	@PutMapping("/reservation/{id}")
	public ResponseEntity<Reservation> updateReservation(@PathVariable Long id,@RequestBody Reservation reservationDetails) {
		Reservation reservation = reservationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Carte not exist with id : "+ id));
		
		reservation.setTimeReservation(reservationDetails.getTimeReservation());
		
		Reservation updateReservation = reservationRepository.save(reservation);
		return ResponseEntity.ok(updateReservation);
	}

	//delete REST api
	@DeleteMapping("/reservation/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteReservation(@PathVariable Long id) {
		Reservation reservation = reservationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Carte not exist with id : "+ id));
		
		reservationRepository.delete(reservation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
