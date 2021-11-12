package com.sps.bookstore.order.dto;

import java.util.ArrayList;
import java.util.List;

import com.sps.bookstore.order.entity.Order;

public class OrderResponse {

	private List<Order> orders = new ArrayList<>();
	private Double totalPrice;
	
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
