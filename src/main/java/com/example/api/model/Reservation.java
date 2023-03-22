package com.example.api.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date reservationDate;
	@Column(name = "reservation_time")
	private String timeReservation;
	private boolean status = true;
	
	public long getReservationId() {
		return reservationId;
	}
	
	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}
	
	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getTimeReservation() {
		return timeReservation;
	}
	
	public void setTimeReservation(String timeReservation) {
		this.timeReservation = timeReservation;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@ManyToOne()
	@MapsId("restaurantId") 
	@JoinColumn(name="restaurant_id") 
	private Restaurant restaurantReserved;
	
	@ManyToOne()
	@MapsId("tableId") 
	@JoinColumn(name="table_id") 
	private Tables tableReserved;
	 
	@ManyToOne()
	@MapsId("foodId") 
	@JoinColumn(name="food_id") 
	private Food foodReserved;
	
	

}
