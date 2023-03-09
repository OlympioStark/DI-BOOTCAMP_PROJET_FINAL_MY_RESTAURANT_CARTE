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
@Table(name = "observation")
public class Observation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="observation_id")
	private long observationId;
	@Column(name = "libelle_observation")
	private String libelleObserv;
	
	public long getObservationId() {
		return observationId;
	}
	public void setObservationId(long observationId) {
		this.observationId = observationId;
	}
	public String getLibelleObserv() {
		return libelleObserv;
	}
	public void setLibelleObserv(String libelleObserv) {
		this.libelleObserv = libelleObserv;
	}
	

}
