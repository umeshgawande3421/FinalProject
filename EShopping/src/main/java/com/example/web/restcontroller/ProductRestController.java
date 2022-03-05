package com.example.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.model.Product;
import com.example.web.serviceimpl.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductRestController {
	
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@GetMapping("/")
	public List<Product> displyDataProduct(){
		
		return productServiceImpl.viewAllProduct();
		
	}
	
	@PostMapping("/")
	public Product addDataProduct(@RequestBody Product product)
	{
		return productServiceImpl.addProduct(product);
	}
	
	@PutMapping("/")
	public Product updateDataProduct(@RequestBody Product product)
	{
		return productServiceImpl.updateProduct(product);
		
	}
	
	@DeleteMapping("/")
	public String removeDataProduct(Long id)
	{
		productServiceImpl.removeProduct(id);
		return "Delete Successfylly";
	}
	

}
