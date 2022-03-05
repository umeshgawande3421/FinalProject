package com.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.web.model.Orders;
import com.example.web.model.User;
import com.example.web.repository.AdminRepository;
import com.example.web.repository.OrderRepository;
import com.example.web.serviceimpl.OrdersServiceImp;

@Controller
public class AdminController {

	@Autowired
	private AdminRepository repository;
	
//	@Autowired
//	private OrderRepository orderRepository;
	
	@Autowired
	private OrdersServiceImp ordersServiceImpl;
	
	@GetMapping("/allusers") // admin see all User details
	public String veiwAllCustomer(Model model) {
		try {
		List<User> listUsers = repository.findAll();
		model.addAttribute("listUsers", listUsers);
		return "admin_allcustomer";  //allcustomer
		}catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
	}
	
	@GetMapping("/usersadmin") // Admin home page
	public String findByemail(String username, Model model)
	{
		try {
		User user = repository.findByEmail(username);
		model.addAttribute("userss",user);
		return "admin_home";  }
		catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
	}
	
	@GetMapping("/allOrders") // Admin see all user order
	public String orderlistAll(Model model)
	{
		try {
		List<Orders> orders = ordersServiceImpl.viewoOrders();
		model.addAttribute("orders",orders);
		System.out.println(orders);
		return "admin_allOrder";
		}catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
	}
	
//	@GetMapping(path = {"/usersadmin","/home_admin"})
//	public String listUsers(Model model) {
//		List<User> listUsers = repository.findAll();
//		model.addAttribute("listUsers", listUsers);
//		
//		return "admin_home"; //home_admin
//	}
}
