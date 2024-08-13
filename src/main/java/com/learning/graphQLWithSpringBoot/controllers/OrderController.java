package com.learning.graphQLWithSpringBoot.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.graphQLWithSpringBoot.entity.Order;
import com.learning.graphQLWithSpringBoot.entity.User;
import com.learning.graphQLWithSpringBoot.service.OrderService;
import com.learning.graphQLWithSpringBoot.service.UserService;

@RestController
public class OrderController {

	private UserService userService;
	
	private OrderService orderService;

	public OrderController(UserService userService, OrderService orderService) {
		super();
		this.userService = userService;
		this.orderService = orderService;
	}
	
	//create order
	@MutationMapping
	public Order createOrder(@Argument int orderId, @Argument String orderDetails, @Argument String address, @Argument int price, @Argument int userId) {
		User user = userService.getUser(userId);
		Order order = new Order();
		order.setAddress(address);
		order.setOrderDetails(orderDetails);
		order.setPrice(price);
		order.setUser(user);
		order.setOrderId(orderId);
		
		Order createOrder = orderService.createOrder(order);
		return createOrder;
	}
	
	@QueryMapping
	public List<Order> getOrders(){
		return orderService.getAll();
	}
	
	@QueryMapping
	public Order getOrder(@Argument int orderId) {
		return orderService.getOrder(orderId);
	}
	
	@MutationMapping
	public boolean deleteOrder(@Argument int orderId) {
		return orderService.deleteOrder(orderId);
	}
}
