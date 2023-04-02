package com.in.cafe.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.cafe.domain.BlogUser;
import com.in.cafe.domain.Comment;
import com.in.cafe.domain.Post;
import com.in.cafe.dto.CommentDto;
import com.in.cafe.exceptions.ResourceNotFoundException;
import com.in.cafe.repository.CommentRepo;
import com.in.cafe.repository.PostRepo;
import com.in.cafe.repository.UserBlogRepository;
import com.in.cafe.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	PostRepo postRepo;
	
	@Autowired
	UserBlogRepository userBlogUser;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	CommentRepo commentRepo;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer userId, Integer postId) {
		System.out.println("================ "+userId + " "+postId + "================" );
		Post post = this.postRepo.findById(postId).orElseThrow(() ->new ResourceNotFoundException("Post", "Id", postId));
		BlogUser uer = 	this.userBlogUser.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setBlogUser(uer);
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);
		CommentDto savedComentDto = this.modelMapper.map(savedComment, CommentDto.class);
		// TODO Auto-generated method stub
		return savedComentDto;
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", " Id ", commentId));
		this.commentRepo.delete(comment);
	}

}
