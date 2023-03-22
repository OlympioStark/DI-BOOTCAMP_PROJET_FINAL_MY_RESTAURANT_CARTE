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
@Table(name = "tables")
public class Tables {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="table_id")
	private long tableId;
	@Column(name = "number_table")
	private int numTable;
	@Column(name = "number_places")
	private int nbPlaces;
	@Column(name = "table_location")
	private String location;
	
	public long getTableId() {
		return tableId;
	}
	public void setTableId(long tableId) {
		this.tableId = tableId;
	}
	public int getNumTable() {
		return numTable;
	}
	public void setNumTable(int numTable) {
		this.numTable = numTable;
	}
	public int getNbPlaces() {
		return nbPlaces;
	}
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
//	@ManyToOne()
//	@MapsId("reservationId") 
//	@JoinColumn(name="reservation_id") 
//	private Tables tableReservation;
	

}
