package com.in.cafe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.cafe.dto.ApiResponse;
import com.in.cafe.dto.BlogCategoryDto;
import com.in.cafe.service.BlogCategoryService;

@RestController
@RequestMapping("/api/v2/categories")
public class CategoryConntoller {

	@Autowired
	BlogCategoryService blogCategoryService;
	//create
	@PostMapping("/")
	public ResponseEntity<BlogCategoryDto> createCategory(@RequestBody BlogCategoryDto blogCategoryDto) {
		BlogCategoryDto createCategory = this.blogCategoryService.createBlogCategory(blogCategoryDto);
		return new ResponseEntity<BlogCategoryDto>(createCategory, HttpStatus.CREATED);
	}
	//update
	
	@PutMapping("/{catId}")
	public ResponseEntity<BlogCategoryDto> updatedCategory(@RequestBody BlogCategoryDto blogCategoryDto, @PathVariable("catId") Integer blogCatId) {
		BlogCategoryDto updatedCategory = this.blogCategoryService.updateCategory(blogCategoryDto, blogCatId);
		return new ResponseEntity<BlogCategoryDto>(updatedCategory, HttpStatus.OK);
	}
	//delete
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("catId") Integer catId) {
		System.out.println(catId);
		this.blogCategoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted data succssfully", true), HttpStatus.OK);
	}
	
	//get
	@GetMapping("/{catId}")
	public ResponseEntity<BlogCategoryDto> getCategory(@PathVariable("catId") Integer blogCatId) {
		BlogCategoryDto blogCategory = this.blogCategoryService.getCategoryById(blogCatId);
		return new ResponseEntity<BlogCategoryDto>(blogCategory, HttpStatus.OK);
	}
	//getAll
	@GetMapping("/")
	public ResponseEntity<List<BlogCategoryDto>> getAllCategories() {
		List<BlogCategoryDto> categoroies = this.blogCategoryService.getAllCategories();
		return new ResponseEntity<List<BlogCategoryDto>>(categoroies, HttpStatus.OK);
	}
}
