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
@Table(name = "reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="reservation_id")
	private long reservationId;
	@Column(name = "reservation_time")
	private String timeReservation;
	
	public long getReservationId() {
		return reservationId;
	}
	
	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}
	
	public String getTimeReservation() {
		return timeReservation;
	}
	
	public void setTimeReservation(String timeReservation) {
		this.timeReservation = timeReservation;
	}
	
	
	
	/*
	 * @ManyToOne()
	 * 
	 * @MapsId("tableId")
	 * 
	 * @JoinColumn(name="table_id") private Tables table;
	 */

}
