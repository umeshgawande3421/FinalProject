package com.example.web.service;

import java.util.Date;
import java.util.List;

import com.example.web.model.Orders;

public interface OrderServices {

	public Orders addOrders(Orders orders);
	public Orders updateOrders(Orders orders);
	public String removeOrders(Orders orders);
	public List<Orders> viewoOrders();
	public List<Orders>viewAllOrders(Date orderDate);
    public List<Orders> viewAllByUserId(String userId);
}