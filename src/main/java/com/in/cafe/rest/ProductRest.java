package com.in.cafe.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.in.cafe.wrapper.ProductWrapper;

@RequestMapping(path="/product")
public interface ProductRest {
	
	@PostMapping(path="/add")
	public ResponseEntity<String> addProduct( @RequestBody(required =true)Map<String, String>requestMap);
	
	@GetMapping(path="/get")
	public ResponseEntity<List<ProductWrapper>> getAllProduct();
	
	@PostMapping("/update")
	public ResponseEntity<String> updateproduct(@RequestBody(required=true) Map<String, String> requestMap);
	
	@PostMapping(path="/delete/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productId);
	
	@PostMapping(path="/updateStatus")
	public ResponseEntity<String> updateStatus(@RequestBody(required=true) Map<String, String> requestMap);
	
	@GetMapping(path="/getByCateogry/{id}")
	public ResponseEntity<List<ProductWrapper>> getByCategory(@PathVariable int id);
	
	@GetMapping(path="/getproductById/{id}")
	public ResponseEntity<ProductWrapper> getProductById(@PathVariable int id);
}
