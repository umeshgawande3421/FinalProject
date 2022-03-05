package com.example.web.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.web.model.Address;
import com.example.web.model.Orders;
import com.example.web.model.Product;
import com.example.web.repository.OrderRepository;
import com.example.web.repository.ProductRepository;
import com.example.web.security.CustomUserDetails;

@Controller
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/addtoOrder/{pid}")
	public String addToCart(@PathVariable Long pid, Orders ord, Model model,
			@AuthenticationPrincipal CustomUserDetails user, Principal principal) {
		try {
			Product product = productRepository.findById(pid).orElse(null);
			// model.addAttribute("p", product);
			ord.setProduct(product);
			// item.setProducts(product);
			Orders orders1 = orderRepository.save(ord);
			orders1.setAddress(user.getAddress());
			System.out.println(user);
			Product proList = orders1.getProduct();
			System.out.println(proList);
			model.addAttribute("proLists", proList);
			model.addAttribute("orders", orders1);
			System.out.println(orders1);
			return "user_ordersList"; }
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 return "Something went wrong";
		}
	}

	@GetMapping("/editOrder/{id}")
	public String showUpdateOrder(@PathVariable("id") Long id, Model model) {
		try {
		Orders orders = orderRepository.getById(id);
		model.addAttribute("orders", orders);
		return "user_orderEdit";}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 return "Something went wrong";
		}
	}

	@PostMapping("/updateOrder/{id}")
	public String updateOrderList(@PathVariable("id") Long id, @Valid Orders orders, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			orders.setOrderId(id);
			return "user_orderEdit";
		}
		orderRepository.save(orders);
		model.addAttribute("ordersList", orderRepository.findAll());
		return "redirect:/listOFOrder";
	}

	@GetMapping("/orderDone")
	public String placeOrder() {
		try {
		return "user_orderCompleted";
		}catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 return "Something went wrong";
		}
	}
}

//addOrder
////double sum = 0;
////for (Cart c : cartRepository.findAll()) {
////sum = sum + c.getSubTotal();
////}
//model.addAttribute("carts", ordersRepository.findAll());
////model.addAttribute("totalPrice", sum);
//return "customerOderPage";
//}
//
//@GetMapping("/addOrder/{id}")
//public String addToCart(@PathVariable("id") Long id, Model model) {
//Product product = productRepository.getById(id);
//List<Cart> carts = cartRepository.findAll();
//boolean itemCheckFlag = true;
//for (Cart c : carts) {
//	if (c.getProducts().getProductId() == id) {
//		//System.out.println("-----============-------------------------------=========");
//		Cart cart = new Cart();
//		cart.setProducts(product);
//		//cart.setQuantity(c.get() + 1);
//		// cart.setCartId(c.getCartId());
//		//cartRepository.dele(c.getCartId());
//		cartRepository.save(cart);
//		itemCheckFlag = false;
//		break;
//	}
//}
//if (itemCheckFlag) {
//	Cart cart = new Cart();
//	cart.setProducts(product);
//	//cart.setQuantity(1);
//	cartRepository.save(cart);
//}
//return "redirect:/order";
//}
//
//
//@GetMapping("/addOrder/{id}")
//public String addToOrder(@PathVariable("id") Long id, Model model) {
//Product product = productRepository.getById(id);
//
//return "redirect:/order";
//}
