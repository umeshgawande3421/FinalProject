package com.example.web.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.model.Address;
import com.example.web.repository.AddressRepository;
import com.example.web.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository repository;

	@Override
	public List<Address> viewAddress(Address address) {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	@Override
	public Address addAddress(Address address) {
		// TODO Auto-generated method stub
		return repository.save(address);
	}

	@Override
	public Address updateAddress(Address address) {
		// TODO Auto-generated method stub
		return repository.save(address);
	}

	@Override
	public String removeAddress(Address address) {
		// TODO Auto-generated method stub
		repository.delete(address);
		return "delete";
	}

	@Override
	public Optional<Address> viewAllAddress(Long addressId) {
		// TODO Auto-generated method stub
		return repository.findById(addressId);
	}

	@Override
	public Address getbyIdAddress(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}