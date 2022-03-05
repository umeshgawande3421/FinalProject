package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.web.model.Cart;
import com.example.web.model.Product;
import com.example.web.repository.CartRepository;
import com.example.web.repository.ProductRepository;
import com.example.web.serviceimpl.CartServiceImpl;
import com.example.web.serviceimpl.ProductServiceImpl;

@Controller
public class CartController {

	@Autowired
	private CartServiceImpl serviceImpl;

//	@Autowired
//	private ProductRepository repository;
	
	@Autowired
	private ProductServiceImpl impl;
	
	@Autowired
	private CartRepository cartRepository;

	@GetMapping("/viewcarts")
	public String displayCartPage() {
		return "user_ProductCart";
	}

	@GetMapping("/addtocart/{id}")
	public String addToCart(@PathVariable("id") Long id, Cart cart, Model model) {
		try {
		Product product = impl.getByIdProduct(id).orElse(null); // edit
		cart.setProduct(product);
		Cart cart2 = cartRepository.save(cart);
		model.addAttribute("productall", product);
		model.addAttribute("carts", cart2);
		System.out.println(cart2);
		return "user_ProductCart";
		}catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 return "Something went wrong";
		}
	}

	@GetMapping("/deleteCart/{id}")
	public String showdelete(@PathVariable Long id) {
		try {
		serviceImpl.removeCartID(id);
		return "user_ProductCart";}catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 return "Something went wrong";
		}
	}

	@GetMapping("/cart")
	public String loadCart(Model model) {
		//System.out.println(cartRepository.findAll());
		model.addAttribute("carts", serviceImpl.viewAllCarts());
		return "user_ProductCart";
	}

	
	
	
//	 
//	 @GetMapping("/addtocart/{pid}")
//	 public String addToCart(@PathVariable Long pid, @ModelAttribute Cart cartItems, Principal principal, Model model){
//		 
//		 Product product = repository.findById(pid).orElse(null);
//		 model.addAttribute("products", product);
//		 cartItems.setProducts(product);
//		 Cart carts=cartRepository.save(cartItems);
//		 model.addAttribute("carts", carts);
//	     return "customerProductCart";
//	 }
//	 
//     cartItems.setSubTotal(product.getPrice());
//     cartItems.setUsername(username);
	// to save to cartItem table.
	// cartService.addToCart(carId, cartItems, principal.getName());

//	@GetMapping("/addtocart/{id}")
//	public String addToCart(@PathVariable("id") Long id, Model model, Cart carted) {
//		Product product = repository.getById(id);
//		//cart.setProduct(product);
//		//Cart cart2 = cartRepository.save(cart);
//		carted.setSubTotal(product.getPrice());
//		model.addAttribute("productall", product);
//		List<Cart> carts = cartRepository.findAll();
//		boolean itemCheckFlag = true;
//		for (Cart c : carts) {
//			if (c.getProduct().getProductId() == id) {
//				System.out.println("-----============-------------------------------=========");
//				Cart cart = new Cart();
//				cart.setProduct(product);
//				// cart.setQuantity(c.get() + 1);
//				cart.setCartId(c.getCartId());
//				cartRepository.deleteById(c.getCartId());
//				cartRepository.save(cart);
//				itemCheckFlag = false;
//				break;
//			}
//		}
//		if (itemCheckFlag) {
//			Cart cart = new Cart();
//			cart.setProduct(product);
//			// cart.setQuantity(1);
//			cartRepository.save(cart);
//		}
//		return "redirect:/cart";
//	}

	/*
	 * @PostMapping("/addCart") public String saveBrand(@ModelAttribute("person")
	 * Product product) { cartService.saveCard(cart); return "redirect:/cart"; }
	 */
}

//@GetMapping(value = "deleteCart/{id}")
//public String delete(@PathVariable("id") Long id) {
//	cartRepository.deleteById(id);
//	return "redirect:/viewcarts";
//}
