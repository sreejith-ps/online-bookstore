package com.sps.bookcheckout.util;

import java.util.HashMap;
import java.util.Map;

public class BookUtil {

	public static Map<String, Double> getCategoriesBasedDiscount() {
		Map<String, Double> map = new HashMap();
		map.put("Fiction", 10D);
		map.put("Romance", 10D);
		map.put("Poetry", 10D);
		map.put("Fiction", 10D);
		map.put("Classic Literature", 10D);
		map.put("NON-FICTION", 10D);
		map.put("Religion", 10D);
		map.put("Politics", 10D);
		map.put("Self- Help", 10D);
		map.put("Autobiographies", 10D);
		map.put("Children's", 10D);
		map.put("Young Adult Fiction", 20D);
		
		return map;
	}
}
