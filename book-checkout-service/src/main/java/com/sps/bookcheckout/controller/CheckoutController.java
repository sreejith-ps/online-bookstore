package com.sps.bookcheckout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sps.bookcheckout.dto.Book;
import com.sps.bookcheckout.dto.TransactionResponse;
import com.sps.bookcheckout.service.CheckoutService;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

	@Autowired
	CheckoutService service;
	
	@GetMapping("/{promoCode}")
	public TransactionResponse doCheckout(@RequestBody List<Book> books, @PathVariable("promoCode") String promotionCode) {
		
		return service.applyDiscount(books, promotionCode);
	}
	
}
