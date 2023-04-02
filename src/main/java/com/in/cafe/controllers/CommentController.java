package com.in.cafe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.cafe.dto.ApiResponse;
import com.in.cafe.dto.CommentDto;
import com.in.cafe.service.CommentService;

@RestController()
@RequestMapping("/api/v2/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/add/{userId}/{postId}")
	public ResponseEntity<CommentDto> crateComment(@RequestBody CommentDto commentDto, @PathVariable("userId") Integer userId, @PathVariable("postId") Integer postId) {
		System.out.println("============="+ userId);
		CommentDto  createdComment = this.commentService.createComment(commentDto, userId, postId);
		return new ResponseEntity<CommentDto>(createdComment, HttpStatus.OK);
		
	}
	@DeleteMapping("/delete")
	public  ApiResponse deleteComment(@PathVariable("commentId") Integer commentId) {
		this.commentService.deleteComment(commentId);
		return new ApiResponse("Deleted Comment successfully", true);
	}
}
