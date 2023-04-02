package com.in.cafe.service;

import java.util.List;

import com.in.cafe.dto.BlogCategoryDto;

public interface BlogCategoryService {
	
public BlogCategoryDto createBlogCategory(BlogCategoryDto blogCategoryDto);
	
	// update
	public BlogCategoryDto updateCategory(BlogCategoryDto blogCategoryDto, Integer blogCatId);
	
	// delete
	public void deleteCategory (Integer blogCatId);
	
	// get
	public BlogCategoryDto getCategoryById(Integer blogCatId);
	
	//get All
	public List<BlogCategoryDto> getAllCategories();
}
