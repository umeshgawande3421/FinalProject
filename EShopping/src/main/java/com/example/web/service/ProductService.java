package com.example.web.service;

import java.util.List;
import java.util.Optional;

import com.example.web.model.Product;


public interface ProductService {
	
	public List<Product> viewAllProduct();
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public Optional<Product> getByIdProduct(Long productId);
	public String removeProduct(Long productId);
}
