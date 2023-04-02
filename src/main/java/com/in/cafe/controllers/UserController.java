package com.in.cafe.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.in.cafe.dto.BlogUserDto;
import com.in.cafe.service.UserBlogService;
import com.in.cafe.dto.ApiResponse;
@RestController
@RequestMapping ("/api/v2/user")
public class UserController {
	
	@Autowired
	private UserBlogService userBlogService;
	
	@PostMapping("/")
	public ResponseEntity<BlogUserDto> createUser (@Valid @RequestBody BlogUserDto blogUserDto) {
		BlogUserDto createdUserDto = this.userBlogService.createUser(blogUserDto);
		return new ResponseEntity<BlogUserDto>(createdUserDto, HttpStatus.CREATED);
	}
	
	// update user
	
	@PutMapping("/{userId}")
	public ResponseEntity<BlogUserDto> updateuser(@Valid @RequestBody BlogUserDto blogUser, @PathVariable("userId") Integer uId) {
		BlogUserDto updatedBloguser = this.userBlogService.updateUser(blogUser, uId);
		// return  ResponseUtil.getResponse(HttpStatus.OK, "Field List",updatedBloguser);
		return ResponseEntity.ok(updatedBloguser);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@Valid @PathVariable("userId") Integer uId) {
		this.userBlogService.deleteUser(uId);
		 return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted successfully", true), HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<BlogUserDto>> GetAllBlogUsers() {
		// List<BlogUserDto> blogUserDto =  
		return ResponseEntity.ok(this.userBlogService.getAllUser());
		//return ResponseUtil.getResponse(HttpStatus.OK, "get all user List", blogUserDto);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<BlogUserDto> GetBlogUser(@Valid @PathVariable("userId") Integer uId) {
		// BlogUserDto blogUserDto =  this.userBlogService.getUserById(uId);
		return ResponseEntity.ok(this.userBlogService.getUserById(uId));
	}
}
