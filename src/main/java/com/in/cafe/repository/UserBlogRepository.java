package com.in.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.cafe.domain.BlogUser;

@Repository
public interface UserBlogRepository extends JpaRepository<BlogUser, Integer> {
	
}
