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

import com.in.cafe.domain.Category;
import com.in.cafe.wrapper.ProductWrapper;

@RequestMapping(path="/category")
public interface RestCategory {
	
	@GetMapping(path="/get")
	public ResponseEntity<List<Category>>geAllCategory(@RequestParam(required= false) String filterValue);
	
	@PostMapping(path="/add")
	public ResponseEntity<String> addNewCategory(@RequestBody(required=true)  Map<String, String> requestMap);
	
	@PostMapping(path="/update")
	public ResponseEntity<String> updateCategory(@RequestBody(required=true) Map<String, String> requestMap);
	
}
