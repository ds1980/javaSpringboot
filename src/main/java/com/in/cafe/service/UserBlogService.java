package com.in.cafe.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.in.cafe.dto.BlogUserDto;

public interface UserBlogService {
	BlogUserDto createUser(BlogUserDto user);
	BlogUserDto updateUser(BlogUserDto user, Integer userId);
	BlogUserDto getUserById(Integer userId);
	List<BlogUserDto> getAllUser();
	void deleteUser(Integer userid);
}
