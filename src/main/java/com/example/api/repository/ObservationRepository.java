package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Observation;

public interface ObservationRepository extends JpaRepository<Observation, Long> {

}
