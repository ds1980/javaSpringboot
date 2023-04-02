package com.in.cafe.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import com.in.cafe.wrapper.ProductWrapper;

public interface ProductService {
	public ResponseEntity<String>addProduct(Map<String, String> requestMap);
	public ResponseEntity<List<ProductWrapper>>GetAllProducts();
	public ResponseEntity<String>updateProduct(Map<String, String> requestMap);
	public ResponseEntity<String>deleteProduct(int productId);
	public ResponseEntity<String>updateProdctStatus(Map<String, String> requestMap);
	public ResponseEntity<List<ProductWrapper>>getByCategory(int id);
	public ResponseEntity<ProductWrapper>getProductById(int id);
}
