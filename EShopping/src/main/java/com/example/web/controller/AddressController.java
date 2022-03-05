package com.example.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.web.model.Address;
import com.example.web.serviceimpl.AddressServiceImpl;

@Controller
public class AddressController {

	@Autowired
	private AddressServiceImpl addressServiceImpl;
	
	@GetMapping("/addressOfUser") // New address filled here
	public String showUserAddress(Model model)
	{
		try {
		Address address = new Address();
		model.addAttribute("address", address);
		return "user_newAddress";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
	}
	
	@PostMapping("/address_add") // Address added and show user_page
	public String saveAdresssData(@ModelAttribute("address") Address address) {
		try {
		addressServiceImpl.addAddress(address);
		return "redirect:/userinfo";}
		catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
	}
}


//@PostMapping("/address_add")
//public String addUserAddress(@Valid Address address, BindingResult result, Model model)
//{
//	 if (result.hasErrors()) {
//            return "user_newAddress";
//        }
//        addressServiceImpl.addAddress(address);
//        return "redirect:/userinfo";
//}