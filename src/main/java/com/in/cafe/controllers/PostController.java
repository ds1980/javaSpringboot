package com.in.cafe.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.in.cafe.dto.ApiResponse;
import com.in.cafe.dto.PostDto;
import com.in.cafe.dto.PostResponse;
import com.in.cafe.service.FileService;
import com.in.cafe.service.PostService;

@RestController()
@RequestMapping("/api/v2/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/user/{blogUserId}/category/{categoryId}")
	public ResponseEntity<PostDto> createPost(
			@RequestBody PostDto postDto,
			@PathVariable Integer blogUserId,
			@PathVariable Integer categoryId
			) {
		PostDto createdPost = this.postService.createPost(postDto, blogUserId, categoryId);
		return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
	}
	
	// get Posts by user Name
		@GetMapping("/user/{blogUserId}/posts")
		public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable("blogUserId") Integer blogUserId) {
			List<PostDto> postsByUser = this.postService.getPostByUser(blogUserId);
			return new ResponseEntity<List<PostDto>>(postsByUser, HttpStatus.OK);
		}
	
	// get post by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable("categoryId") Integer categoryId) {
		List<PostDto> postByCategory = this.postService.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postByCategory, HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value="pageNumber", defaultValue="0", required= false) Integer pageNumber,
			@RequestParam(value="pageSize", defaultValue="5", required = false) Integer pageSize,
			@RequestParam(value="sortBy", defaultValue="postId", required = false) String sortBy,
			@RequestParam(value="sortDir", defaultValue="asc", required= false) String sortDir
			) {
		PostResponse allPosts = this.postService.getAllPost(pageSize, pageNumber, sortBy, sortDir);
		return new ResponseEntity<PostResponse>(allPosts, HttpStatus.OK);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<PostDto> getSinglePost(@PathVariable("postId") Integer postId) {
		PostDto singlePost = this.postService.getSinglePost(postId);
		return new ResponseEntity<PostDto>(singlePost, HttpStatus.OK);
	}
	
	@PutMapping("/update/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postData, @PathVariable("postId") Integer postId) {
		PostDto updatedPost = this.postService.updatePost(postData, postId);
		return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{postId}")
	public ApiResponse deletePost(@PathVariable("postId") Integer postId) {
		this.postService.deletePost(postId);
		return new ApiResponse("Record Deleted successfully", true);
	}
	
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<PostDto>> serchPost(@PathVariable("keyword") String keyword) {
		List<PostDto> serchedPost = this.postService.searchPosts(keyword);
		return new ResponseEntity<List<PostDto>>(serchedPost, HttpStatus.OK);
	}
	
	@PostMapping("/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadPostImage(
			@RequestParam("image") MultipartFile image,
			@PathVariable Integer postId
			) throws IOException {
		PostDto postDto = this.postService.getSinglePost(postId);
		
		String fileName = this.fileService.uploadImage(path, image);
		postDto.setImageName(fileName);
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
	}
	
	@GetMapping(value="/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downLoadImage(@PathVariable("imageName") String imageName,
			HttpServletResponse response
			) throws IOException {
		InputStream resources = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		org.hibernate.engine.jdbc.StreamUtils.copy(resources, response.getOutputStream());
		
	}
}
