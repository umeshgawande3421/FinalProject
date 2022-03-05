package com.example.web.restcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.model.Orders;
import com.example.web.serviceimpl.OrdersServiceImp;

@RestController
@RequestMapping("/order")
public class OrdersRestControllers {

	@Autowired
	OrdersServiceImp ordersServiceImp;

	@GetMapping("/")
	public List<Orders> viewallDataOrder() {
		return ordersServiceImp.viewoOrders();
	}

	@PostMapping("/")
	public Orders adOrdersDataOrder(@RequestBody Orders orders) {

		return ordersServiceImp.addOrders(orders);
	}

	@PutMapping("/")
	public Orders updateDataOrder(@RequestBody Orders orders) {
		return ordersServiceImp.updateOrders(orders);
	}

	@DeleteMapping("/")
	public String deleteoredersDataOrder(@RequestBody Orders orders) {

		ordersServiceImp.removeOrders(orders);
		return "Delete Successfully";
	}

	@GetMapping("/{orderDate}")
	public List<Orders> viewAllOrdersDataOrder(@PathVariable("orderDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date orderDate) {
		return ordersServiceImp.viewAllOrders(orderDate);
	}

	@GetMapping("/viewallbyuserId")
	public List<Orders> viewAllByUserIdDataOrder(@PathVariable(name = "userId") String userId) {
		return ordersServiceImp.viewAllByUserId(userId);
	}

}
