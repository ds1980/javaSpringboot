package com.in.cafe.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.cafe.domain.BlogCategory;
import com.in.cafe.domain.Category;
import com.in.cafe.dto.BlogCategoryDto;
import com.in.cafe.exceptions.ResourceNotFoundException;
import com.in.cafe.repository.BlogCategoryRepo;
import com.in.cafe.service.BlogCategoryService;

@Service
public class BlogCategoryServiceImpl implements BlogCategoryService {

	@Autowired
	BlogCategoryRepo blogCategoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public BlogCategoryDto createBlogCategory(BlogCategoryDto blogCategoryDto) {
		
		BlogCategory blogCategory = this.modelMapper.map(blogCategoryDto, BlogCategory.class);
		System.out.println(blogCategory.getCategoryTitle());
		BlogCategory blogCategorySaved = blogCategoryRepo.save(blogCategory);
		BlogCategoryDto blogCategoryDtoSaved = this.modelMapper.map(blogCategorySaved, BlogCategoryDto.class);
		return blogCategoryDtoSaved;
	}

	@Override
	public BlogCategoryDto updateCategory(BlogCategoryDto blogCategoryDto, Integer blogCatId) {
		BlogCategory blogCategory = blogCategoryRepo.findById(blogCatId).orElseThrow(() -> new ResourceNotFoundException("Blog Category", "Category Id ", blogCatId));
		blogCategory.setCategoryTitle(blogCategoryDto.getCategoryTitle());
		blogCategory.setCategoryDescription(blogCategoryDto.getCategoryDescription());
		BlogCategory updatedData = blogCategoryRepo.save(blogCategory);
		return this.modelMapper.map(updatedData, BlogCategoryDto.class);
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteCategory(Integer blogCatId) {
		BlogCategory cate = this.blogCategoryRepo.findById(blogCatId).orElseThrow(() -> new ResourceNotFoundException("Blog Category", "Category id ", blogCatId));
		this.blogCategoryRepo.delete(cate);
	}

	@Override
	public BlogCategoryDto getCategoryById(Integer blogCatId) {
		BlogCategory cat = this.blogCategoryRepo.findById(blogCatId).orElseThrow(() -> new ResourceNotFoundException("Blog Category", "Category Id", blogCatId));
		// TODO Auto-generated method stub
		return this.modelMapper.map(cat, BlogCategoryDto.class);
	}

	@Override
	public List<BlogCategoryDto> getAllCategories() {
		List<BlogCategory> BlogCategoryList = this.blogCategoryRepo.findAll();
		List<BlogCategoryDto> catDtoes = BlogCategoryList.stream().map((cat) -> this.modelMapper.map(cat, BlogCategoryDto.class)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return catDtoes;
	}

}
