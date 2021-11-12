package com.sps.bookstore.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sps.bookstore.order.dto.Book;
import com.sps.bookstore.order.entity.Order;
import com.sps.bookstore.order.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/addOrder")
	public Order addOrder(@RequestBody Order order) {
		return orderService.saveOrder(order);
	}
	
	@GetMapping("/checkout/{promoCode}")
	public String checkoutOrder(@RequestBody List<Book> orders, @PathVariable("promoCode") String promoCode) {
		orders.stream().forEach(t -> System.out.println(t.getName()));
		System.out.println("Promo code : " + promoCode);
		return "checkout from order controller..";
	}

	@GetMapping
	public String checkOutBooks() {
		return "checkout...";
	}
}
