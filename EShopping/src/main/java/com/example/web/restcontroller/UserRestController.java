package com.example.web.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.model.User;
import com.example.web.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/customerUser")
public class UserRestController {

	@Autowired(required = true)
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/{id}")
	public Optional<User> selfUserDara(Long id)
	{
		return userServiceImpl.oneCustomer(id);
	}
	
	@GetMapping("/")
	public List<User> AllDataCustomers(User user)
	{
		return userServiceImpl.allCustomers(user);
	}
	
	@PostMapping("/")
	public User saveDataUser(@RequestBody User user)
	{
		return userServiceImpl.saveCustomers(user);
	}
	
	@PutMapping("/")
	public User updateDataUser(@RequestBody User user)
	{
		return userServiceImpl.saveCustomers(user);
	}
	
	@DeleteMapping("/")
	public String deleteDataUser(@RequestBody User user)
	{
		userServiceImpl.saveCustomers(user);
		return "delete Done";
	}
}
