package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
