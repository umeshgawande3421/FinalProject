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

import com.example.web.model.Cart;
import com.example.web.model.Product;
import com.example.web.serviceimpl.CartServiceImpl;


@RestController
@RequestMapping("/cart")
public class CartRestController {
	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@GetMapping("/")
	public  List<Cart> displayDataCart(@RequestBody Cart cart)
	{
		return cartServiceImpl.viewCarts(cart);
	}
	
	@PostMapping("/")
	public Cart addProductDataCart(@RequestBody Cart cart,Product product,int quantity)
	{
		return cartServiceImpl.addProductToCart(cart, product, quantity);
		
	}
	
	@PutMapping("/")
	public Cart updateDataCart(@RequestBody Cart cart,Product product)
	{
		return  cartServiceImpl.updateProductFrommCart(cart, product);
	}
	
	
	@DeleteMapping("/pcart")
	public String deleteProductFromCartDataCart(@RequestBody Cart cart, Product product)
	{
		cartServiceImpl.removeProductFromCart(cart, product);
		return "deleted from Cart";
	}
	@DeleteMapping("/")
	public String deleteDataCart(@RequestBody Cart cart)
	{
		cartServiceImpl.removeAllProduct(cart);
		return "Deleted Successfully";
	}

	

}
