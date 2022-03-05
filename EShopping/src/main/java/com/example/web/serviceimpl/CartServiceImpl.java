package com.example.web.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.model.Cart;
import com.example.web.model.Product;
import com.example.web.repository.CartRepository;
import com.example.web.service.CartService;


@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<Cart> viewAllCarts() {
		// TODO Auto-generated method stub
		return cartRepository.findAll();
	}

	@Override
	public Cart addProductToCart(Cart cart, Product product, Integer quantity) {
		// TODO Auto-generated method stub
		return cartRepository.save(cart);
	}

	@Override
	public Cart updateProductFrommCart(Cart cart, Product product) {
		// TODO Auto-generated method stub
		return cartRepository.save(cart);
	}

	@Override
	public String removeProductFromCart(Cart cart, Product product) {
		// TODO Auto-generated method stub
		 cartRepository.deleteAll();
		 return "Delete Done";
	}

	@Override
	public String removeAllProduct(Cart cart) {
		// TODO Auto-generated method stub
		 cartRepository.delete(cart);
		 return "delete done";
	}

	@Override
	public String removeCartID(Long id) {
		// TODO Auto-generated method stub
		cartRepository.deleteById(id);
		return "delete";
	}

	@Override
	public Optional<Cart> addProductById(Cart cart, Long id) {
		// TODO Auto-generated method stub
		return cartRepository.findById(id);
	}

	@Override
	public List<Cart> viewCarts(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepository.findAll();
	}
	
//	public List<Cart> myCart(String email){
//
//	    List<Cart> cartItems = new ArrayList();
//	    cartRepository.findByUsername(email).forEach(cartItems::add);
//
//	    return cartItems;
//	}
//	
//	public void addToCart(Long carId, Cart cartItems, User user) {
//
//		Product product = productRepository.findById(carId).orElse(null);
//		cartItems.setProduct(product);
//
//		cartItems.setSubTotal(product.getPrice());
//		cartItems.setUser(user);
//
//		cartRepository.save(cartItems);
//
//	}
}
