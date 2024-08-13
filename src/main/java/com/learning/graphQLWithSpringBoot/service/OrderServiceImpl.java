package com.learning.graphQLWithSpringBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.graphQLWithSpringBoot.entity.Order;
import com.learning.graphQLWithSpringBoot.helper.ExceptionHelper;
import com.learning.graphQLWithSpringBoot.repositories.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{

	private OrderRepo orderRepo;

	public OrderServiceImpl(OrderRepo orderRepo) {
		this.orderRepo = orderRepo;
	}
	
	@Override
	public Order createOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public List<Order> getAll() {
		return orderRepo.findAll();
	}

	@Override
	public Order getOrder(int orderId) {
		return orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
	}

	@Override
	public boolean deleteOrder(int orderId) {
		Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
		orderRepo.delete(order);
		return true;
	}
	
	
	
	
}
