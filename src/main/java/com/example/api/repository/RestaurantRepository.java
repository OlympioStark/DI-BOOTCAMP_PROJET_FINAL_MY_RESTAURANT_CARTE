package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

}
