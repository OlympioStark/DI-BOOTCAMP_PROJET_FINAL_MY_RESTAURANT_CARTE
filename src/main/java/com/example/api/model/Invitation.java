package com.example.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invitation")
public class Invitation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="invitation_id")
	private long invitationId;
	@Column(name = "guest_email")
	private String emailGuest;
	@Column(name = "guest_fullname")
	private String fullName;
	@Column(name = "guest_number")
	private String numGuest;
	
	public long getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(long invitationId) {
		this.invitationId = invitationId;
	}
	public String getEmailGuest() {
		return emailGuest;
	}
	public void setEmailGuest(String emailGuest) {
		this.emailGuest = emailGuest;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getNumGuest() {
		return numGuest;
	}
	public void setNumGuest(String numGuest) {
		this.numGuest = numGuest;
	}
	

}
