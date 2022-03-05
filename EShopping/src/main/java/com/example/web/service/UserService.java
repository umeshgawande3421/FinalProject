package com.example.web.service;

import java.util.List;
import java.util.Optional;

import com.example.web.model.User;

public interface UserService {
	
	public Optional<User> oneCustomer(Long id);
	public User saveCustomers(User user);
	public User updateCustomers(User user);
	public List<User> allCustomers(User user);
	public String deleteCustomer(User user);
}
