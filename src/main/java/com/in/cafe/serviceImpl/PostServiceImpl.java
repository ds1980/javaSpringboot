package com.in.cafe.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.in.cafe.domain.BlogCategory;
import com.in.cafe.domain.BlogUser;
import com.in.cafe.domain.Post;
import com.in.cafe.dto.PostDto;
import com.in.cafe.dto.PostResponse;
import com.in.cafe.exceptions.ResourceNotFoundException;
import com.in.cafe.repository.BlogCategoryRepo;
import com.in.cafe.repository.PostRepo;
import com.in.cafe.repository.UserBlogRepository;
import com.in.cafe.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserBlogRepository userBlogRepo;
	
	@Autowired
	BlogCategoryRepo blogCategoryRepo;
	
	@Override
	public PostDto createPost(PostDto postDto, Integer blogUserId, Integer categoryId) {
		
	 	BlogUser blogUser = this.userBlogRepo.findById(blogUserId).orElseThrow(() -> new ResourceNotFoundException("UserBlog ", " Id ", blogUserId));
		BlogCategory blogCategory = this.blogCategoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category Blog", "", categoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddDate(new Date());
		post.setBloguser(blogUser);
		post.setBlogCategory(blogCategory);
		Post savedost = this.postRepo.save(post);
		return this.modelMapper.map(savedost, PostDto.class);
		
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post ", " Id ", postId));
		// TODO Auto-generated method stub
		post.setTitle(postDto.getTitle());
		post.setComment(postDto.getComment());
		post.setImageName(postDto.getImageName());
		Post savedPost = this.postRepo.save(post);
		return this.modelMapper.map(savedPost, PostDto.class);
		
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post ", " Id ", postId));
		this.postRepo.delete(post);
		// TODO Auto-generated method stub

	}

	@Override
	public PostResponse getAllPost(Integer pageSize, Integer pageNumber, String sortBy, String sortDir) {
		
		Sort sort = sortDir.equalsIgnoreCase("asc") ?  Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		
		Pageable p = PageRequest.of(pageNumber, pageSize, sort);
		Page<Post> pagePost = this.postRepo.findAll(p);	
		
		List<Post> posts = pagePost.getContent();
		List<PostDto> allPost = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(allPost);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalpages(pagePost.getTotalPages());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setLastpage(pagePost.isLast());
		return postResponse;
	}

	@Override
	public PostDto getSinglePost(Integer postId) {
		Post post = this.postRepo.findById(postId).orElse(null);
		PostDto postDto = this.modelMapper.map(post, PostDto.class);
		return postDto;
	
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
	  BlogCategory	cat = this.blogCategoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category ", "categoryId", categoryId));
	  List<Post> posts = this.postRepo.findByBlogCategory(cat);
	  List<PostDto> PostByCategory = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	  return PostByCategory;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		BlogUser blogUser =  this.userBlogRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		List<Post> posts = this.postRepo.findByBloguser(blogUser);
		List<PostDto> postByUser = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return postByUser;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		List<Post> serchedPost = this.postRepo.serchPostByKey("%"+keyword+"%");
		List<PostDto> postList = serchedPost.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return postList;
	}

}
