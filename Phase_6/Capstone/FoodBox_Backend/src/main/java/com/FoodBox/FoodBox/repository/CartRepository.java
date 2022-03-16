package com.FoodBox.FoodBox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodBox.FoodBox.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
