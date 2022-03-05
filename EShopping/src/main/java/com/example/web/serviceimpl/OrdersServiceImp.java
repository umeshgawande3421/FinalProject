package com.example.web.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.model.Orders;
import com.example.web.repository.OrderRepository;
import com.example.web.service.OrderServices;

@Service
public class OrdersServiceImp implements OrderServices {

	@Autowired
	OrderRepository ordersRepository;

	@Override
	public Orders addOrders(Orders orders) {
		return ordersRepository.save(orders);
	}

	@Override
	public Orders updateOrders(Orders orders) {

		return ordersRepository.save(orders);
	}

	@Override
	public String removeOrders(Orders orders) {

		ordersRepository.delete(orders);
		return "removed";
	}

	@Override
	public List<Orders> viewoOrders() {
		return ordersRepository.findAll();
	}

	@Override
	public List<Orders> viewAllOrders(Date orderDate) {
		return ordersRepository.findAll();
	}

	@Override
	public List<Orders> viewAllByUserId(String userId) {
		return ordersRepository.findAll();
	}

}
