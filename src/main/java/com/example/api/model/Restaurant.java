package com.example.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurant")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="restaurant_id")
	private long id;
	@Column(name = "restaurant_wording")
	private String libRestaurant;
	@Column(name = "localisation")
	private String localisation;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibRestaurant() {
		return libRestaurant;
	}
	public void setLibRestaurant(String libRestaurant) {
		this.libRestaurant = libRestaurant;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
	@ManyToOne()
	@MapsId("tableId") 
	@JoinColumn(name="table_id") 
	private Tables tableRestaurant;
	
	

}
