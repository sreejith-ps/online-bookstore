package com.sps.bookstore.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sps.bookstore.order.dto.OrderResponse;
import com.sps.bookstore.order.dto.TransactionRequest;
import com.sps.bookstore.order.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
//	@PostMapping("/addOrder")
//	public Order addOrder(@RequestBody Order order) {
//		return orderService.saveOrder(order);
//	}
	
	@PostMapping("/checkout/{promoCode}")
	public String checkoutOrder(@RequestBody TransactionRequest request, @PathVariable("promoCode") String promoCode) {
		OrderResponse response = orderService.checkoutOrder(request, promoCode);
		
		response.getOrders().stream().forEach(t -> System.out.println(t.getName()));
		System.out.println("Promo code : " + promoCode);
		return "Total Price : " + response.getTotalPrice();
	}

	@GetMapping
	public String checkOutBooks() {
		return "checkout...";
	}
}
