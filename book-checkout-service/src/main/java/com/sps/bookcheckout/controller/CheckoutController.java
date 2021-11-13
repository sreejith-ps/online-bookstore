package com.sps.bookcheckout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sps.bookcheckout.dto.TransactionRequest;
import com.sps.bookcheckout.dto.TransactionResponse;
import com.sps.bookcheckout.service.CheckoutService;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

	@Autowired
	CheckoutService service;
	
	@PostMapping //("/{promoCode}")
	public TransactionResponse doCheckout(@RequestBody TransactionRequest request) { //, @PathVariable("promoCode") String promotionCode) {
		
		return service.applyDiscount(request.getBooks(), request.getPromocode());
	}
	
//	@GetMapping("/{promoCode}")
//	public TransactionResponse doCheckout(@RequestBody List<Book> books, @PathVariable("promoCode") String promotionCode) {
//		
//		return service.applyDiscount(books, promotionCode);
//	}
	
}
