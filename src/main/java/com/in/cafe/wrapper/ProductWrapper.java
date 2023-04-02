package com.in.cafe.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductWrapper {
	int id;
	
	String name;
	
	String description;
	
	float price;
	
	String status;
	
	int categoryId;
	
	String categoryName;
	
	public ProductWrapper(int id, String name, String description, float price, String status, int categoryId,
			String categoryName) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	public ProductWrapper(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public ProductWrapper(int id, String name, String description, float price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
}
