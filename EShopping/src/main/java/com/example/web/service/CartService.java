package com.example.web.service;


import java.util.List;
import java.util.Optional;

import com.example.web.model.Cart;
import com.example.web.model.Product;

public interface CartService {
	
	public List<Cart> viewAllCarts();
	public List<Cart> viewCarts(Cart cart);
	public Cart addProductToCart(Cart cart, Product product, Integer quantity);
	public Optional<Cart> addProductById(Cart cart, Long id);
	public Cart updateProductFrommCart(Cart cart, Product product);
	public String removeProductFromCart(Cart cart, Product product);
	public String removeAllProduct(Cart cart);
	public String removeCartID(Long id);

}