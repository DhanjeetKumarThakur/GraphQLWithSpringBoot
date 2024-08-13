package com.learning.graphQLWithSpringBoot.service;

import java.util.List;

import com.learning.graphQLWithSpringBoot.entity.Order;

public interface OrderService {

	//create Order
	public Order createOrder(Order order);
	
	//Get all orders
	public List<Order> getAll();
	
	//Get Single Order
	public Order getOrder(int orderId);
	
	//delete order
	public boolean deleteOrder(int orderId);
}
