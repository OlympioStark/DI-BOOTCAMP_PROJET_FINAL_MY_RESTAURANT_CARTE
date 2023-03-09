package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Carte;

public interface CarteRepository extends JpaRepository<Carte, Long> {

}
