package com.in.cafe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.cafe.domain.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>  {
	public List<Category>getAllCategories();
}
