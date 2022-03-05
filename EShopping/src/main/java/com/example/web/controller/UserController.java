package com.example.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.web.model.Product;
import com.example.web.model.User;
import com.example.web.repository.UserRepository;
import com.example.web.security.CustomUserDetails;
import com.example.web.serviceimpl.ProductServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo; // 

	@Autowired
	private ProductServiceImpl serviceImpl; // Business Logic

	@GetMapping("/main") // main page
	public String viewHomePage() {
		return "welcome_page"; // index
	}

	@GetMapping("/userinfo")  // user details page
	public String veiwCustomer(@AuthenticationPrincipal CustomUserDetails user, Model model) {
		try {
		model.addAttribute("user", user);
		return "user_Customer"; }
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 return "Something went wrong";
		}
	}

	@GetMapping("/editUser/{id}") // user edit page
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		try {
		User user = userRepo.getById(id);
		model.addAttribute("user", user);
		return "update_Customer";}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 return "Something went wrong";
		}
	}

	@PostMapping("/updateUser/{id}") // update user page
	public String updateCustomerForm(@PathVariable("id") Long id, @Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update_Customer";
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);
		model.addAttribute("self", userRepo.findAll());
		return "redirect:/main"; // home
	}

	@GetMapping("/register")  // new user register
	public String showRegistrationForm(Model model) {
		try {
		model.addAttribute("user", new User());
		return "user_signup_form";}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 return "Something went wrong";
		}
	}

	@PostMapping("/process_register") // password
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);
		return "user_register_success";
	}

	@GetMapping(path = { "/users", "/usersback"})  // user home page
	public String listUsersOnly(Model model, @Param("keyword") String keyword) {
		try {
		List<User> listUsers = userRepo.findAll();
		List<Product> listProducts = serviceImpl.listAll(keyword);
		model.addAttribute("listUsers", listUsers);
		// model.addAttribute("listProducts", products);
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("keyword", keyword);
		return "user_Home";}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 return "Something went wrong";
		}
	}
}












//@GetMapping("/deleteUser/{id}")
//public String deleteStudent(@PathVariable("id") Long id, Model model) {
//  Optional<User> student = userRepo.findById(id);//.orElseThrow(() - > new IllegalArgumentException("Invalid student Id:" + id));
//  userRepo.deleteById(id);
//  model.addAttribute("students", userRepo.findAll());
//  return "index";
//}