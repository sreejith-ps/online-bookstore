package com.sps.bookstore.order.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sps.bookstore.order.dto.Book;
import com.sps.bookstore.order.dto.OrderResponse;
import com.sps.bookstore.order.dto.TransactionRequest;
import com.sps.bookstore.order.dto.TransactionResponse;
import com.sps.bookstore.order.entity.Order;
import com.sps.bookstore.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate template;
	
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
	

	public void saveOrders(List<Order> orders) {
		
		orders.forEach(order ->
			orderRepository.save(order));
	}

	public OrderResponse checkoutOrder(TransactionRequest request, String promoCode) {
		request.setPromocode(promoCode); 
		TransactionResponse response = template.postForObject("http://localhost:8083/api/checkout" , request, TransactionResponse.class);
		List<Book> books = response.getBooks();
		List<Order> orders = books.stream().map(book -> new Order(null, book.getIsbn(), book.getName(), book.getQuantity(), book.getDiscount(), book.getPrice())).collect(Collectors.toList());
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrders(orders);
		orderResponse.setTotalPrice(response.getTotalPrice());
		
		// saveOrders(orders); 		//here call the save of order if we wanted to persist the order - which is beyond the scope of requirement
		return orderResponse;
	}

}
