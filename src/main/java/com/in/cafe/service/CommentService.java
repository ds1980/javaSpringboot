package com.in.cafe.service;

import com.in.cafe.dto.CommentDto;

public interface CommentService  {
	public CommentDto createComment(CommentDto commentDto, Integer userId, Integer postId);
	public void deleteComment(Integer commentId);
}
