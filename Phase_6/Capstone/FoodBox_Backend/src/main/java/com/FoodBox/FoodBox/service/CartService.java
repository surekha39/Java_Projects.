package com.FoodBox.FoodBox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodBox.FoodBox.model.Cart;
import com.FoodBox.FoodBox.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;

	public void saveCart(Cart cart) {
		cartRepository.save(cart);		
	}
	
	public List<Cart> getAllCart() {
		return cartRepository.findAll();
	}
	
	public void cartDeleteAll() {
		cartRepository.deleteAll();
	}
}