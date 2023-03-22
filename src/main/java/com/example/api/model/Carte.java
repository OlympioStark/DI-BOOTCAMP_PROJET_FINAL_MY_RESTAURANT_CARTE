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
@Table(name = "carte")
public class Carte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="carte_id")
	private long carteId;
	@Column(name = "wording_carte")
	private String libCarte;
	
	public long getCarteId() {
		return carteId;
	}
	public void setCarteId(long carteId) {
		this.carteId = carteId;
	}
	public String getLibCarte() {
		return libCarte;
	}
	public void setLibCarte(String libCarte) {
		this.libCarte = libCarte;
	}
	

}
