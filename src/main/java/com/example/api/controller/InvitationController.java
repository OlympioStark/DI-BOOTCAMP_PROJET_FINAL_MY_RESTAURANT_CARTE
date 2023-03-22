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
import com.example.api.model.Invitation;
import com.example.api.repository.InvitationRepository;

@RestController
@RequestMapping("/api/mrc/inv")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class InvitationController {
	
	@Autowired
	private InvitationRepository invitationRepository;
	
	//get all customer REST api
	@GetMapping("/invitation")
	public List<Invitation> getAllUsers() {
		return invitationRepository.findAll();
	}
	
	//create customer
	@PostMapping("/invitation")
	public Invitation createInvitation(@RequestBody Invitation invitation) {
		return invitationRepository.save(invitation);
	}
	
	//get one customer REST api
	@GetMapping("/invitation/{id}")
	public ResponseEntity<Invitation> getInvitation(@PathVariable Long id) {
		Invitation invitation = invitationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invitation not exist with id : "+ id));
		return ResponseEntity.ok(invitation);
	}
	
	//update REST api
	@PutMapping("/invitation/{id}")
	public ResponseEntity<Invitation> updateObservation(@PathVariable Long id,@RequestBody Invitation invitationDetails) {
		Invitation invitation = invitationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invitation not exist with id : "+ id));
		
		invitation.setEmailGuest(invitationDetails.getEmailGuest());
		invitation.setFullName(invitationDetails.getFullName());
		invitation.setNumGuest(invitationDetails.getNumGuest());
		
		Invitation updateInvitation = invitationRepository.save(invitation);
		return ResponseEntity.ok(updateInvitation);
	}

	//delete REST api
	@DeleteMapping("/invitation/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTables(@PathVariable Long id) {
		Invitation tables = invitationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invitation not exist with id : "+ id));
		
		invitationRepository.delete(tables);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
