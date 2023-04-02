package com.in.cafe.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.in.cafe.domain.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostDto {
	private int postId;
	
	private String title;
	
	private int categoryId;
	
	private int blogUserId;
	
	private String comment;
	
	private String imageName;
	
	private Date addDate;
	
	private BlogCategoryDto blogCategory;
	
	private BlogUserDto bloguser;
	
	private Set<CommentDto> comments = new HashSet<>();
}
