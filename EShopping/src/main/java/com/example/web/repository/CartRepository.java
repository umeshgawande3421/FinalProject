package com.example.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	public List<Cart> findByCartId(Long cartId); 
}