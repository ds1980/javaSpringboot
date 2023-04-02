package com.in.cafe.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.in.cafe.domain.Category;


public interface CategoryService {
	public ResponseEntity<List<Category>> geAllCategory(String filterValue);
	public ResponseEntity<String>addNewCategory( Map<String, String> requestMap);
	public ResponseEntity<String> updateCategory(Map<String, String> requestMap);
}
