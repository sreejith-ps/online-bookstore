package com.sps.bookstore.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sps.bookstore.order.entity.Order;
import com.sps.bookstore.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

}
