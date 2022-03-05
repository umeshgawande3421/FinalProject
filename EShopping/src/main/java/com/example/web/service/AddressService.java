package com.example.web.service;

import java.util.List;
import java.util.Optional;

import com.example.web.model.Address;

public interface AddressService {

	public List<Address> viewAddress(Address address);
	public Address addAddress(Address address);
	public Address getbyIdAddress(Long id);
	public Address updateAddress(Address address);
	public String removeAddress(Address address);
	public Optional<Address> viewAllAddress(Long addressId);
}
