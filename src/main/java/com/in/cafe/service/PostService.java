package com.in.cafe.service;

import java.util.List;

import com.in.cafe.domain.Post;
import com.in.cafe.dto.PostDto;
import com.in.cafe.dto.PostResponse;

public interface PostService {
	
	// create
	public PostDto createPost(PostDto postDto, Integer blogUserId, Integer categoryId);
	
	//update post
	public PostDto updatePost(PostDto postDto, Integer postId);
	
	// delete post
	public void deletePost(Integer postId);
	
	// get all Posts
	PostResponse getAllPost(Integer pageSize, Integer pageNumber, String sortBy, String sortDir);
	
	// get single post
	PostDto getSinglePost(Integer postId);
	
	// get all post by Category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	// get All post by users
	List<PostDto> getPostByUser(Integer userId);
	
	// search posts
	List<PostDto> searchPosts(String keyword);
	
}
