package com.sps.bookcheckout.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sps.bookcheckout.dto.Book;
import com.sps.bookcheckout.dto.TransactionResponse;
import com.sps.bookcheckout.util.BookUtil;

@Service
public class CheckoutService {

	public TransactionResponse applyDiscount(List<Book> books, String promoCode) {
		TransactionResponse response = new TransactionResponse();
		Map<String, Double> discountMap = BookUtil.getCategoriesBasedDiscount();
		Double totalPrice = books.stream().
				map(book -> book.getPrice() * book.getQuantity() * (null != promoCode && null != discountMap.get(book.getType()) ? (1 - discountMap.get(book.getType())/100) : 1)).
				reduce(0D, (a,b) -> a+b);
		response.setTotalPrice(totalPrice);
		return response;
	}

}
