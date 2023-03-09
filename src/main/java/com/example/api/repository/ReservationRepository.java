package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
