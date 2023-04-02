package com.in.cafe.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.collections.map.HashedMap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="post")
@Setter
@Getter
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	@Column(name="post_title", length=100, nullable = false)
	private String title;
	
	@Column(name="post_comment", length=1000, nullable=false)
	private String comment;
	
	private String imageName;
	private Date addDate;
	
	@ManyToOne
	@JoinColumn(name="cat_id")
	private BlogCategory blogCategory;
	
	@ManyToOne
	@JoinColumn(name="blog_user_id")
	private BlogUser bloguser;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();
	
}
