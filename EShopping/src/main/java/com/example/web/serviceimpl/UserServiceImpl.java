package com.example.web.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.model.User;
import com.example.web.repository.UserRepository;
import com.example.web.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> oneCustomer(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public User saveCustomers(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User updateCustomers(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> allCustomers(User user) {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public String deleteCustomer(User user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);
		return "delete Done";
	}	
}