package com.example.web.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.model.Address;
import com.example.web.serviceimpl.AddressServiceImpl;

@RestController
@RequestMapping("/address")
public class AddressRestController {

	@Autowired
	AddressServiceImpl addressServiceImp;

	@GetMapping("/")
	public List<Address> viewDataAddress(Address address) {
	// TODO Auto-generated method stub
	return addressServiceImp.viewAddress(address);
	}

	@PostMapping("/")
	public Address addDataAddress(Address address) {
	// TODO Auto-generated method stub
	return addressServiceImp.addAddress(address);

	}
	@PutMapping("/")
	public Address updateDataAddress(Address address) {
	return addressServiceImp.updateAddress(address);
	}

	@DeleteMapping("/")
	public String removeDataAddress(Address address) {
	// TODO Auto-generated method stub
	addressServiceImp.removeAddress(address);
	return "deleteet Successfully";
	}

	@GetMapping("/{addressId}")
	public Optional<Address> viewAllDataAddress(Long addressId) {
	return addressServiceImp.viewAllAddress(addressId);
	}
}
