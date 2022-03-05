package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
Project Name: Online Shopping
Team Member: Ajay Aglave, Abhijit Advitot, Akshay Meshram, Shubham Kavade, Umesh Gawande
Date: 26/02/2020 to 05/03/2020
Description: This is our project main class execution 
		Begins form here.
*/
@SpringBootApplication
@EnableJpaAuditing
public class EShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EShoppingApplication.class, args);
	}
}