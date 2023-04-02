package com.in.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.cafe.domain.BlogCategory;

public interface BlogCategoryRepo extends JpaRepository<BlogCategory, Integer> {

}
