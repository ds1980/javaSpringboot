package com.in.cafe.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="blog_user")
@Setter
@Getter
@NoArgsConstructor
public class BlogUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="b_user_name", nullable= false, length=100)
	private String name;
	private String email;
	private String password;
	private String about;
	
	@OneToMany(mappedBy = "bloguser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> post = new ArrayList<Post>();
	
	@OneToMany(mappedBy = "blogUser", cascade = CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();
}
