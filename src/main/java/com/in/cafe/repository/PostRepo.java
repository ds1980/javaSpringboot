package com.in.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.in.cafe.domain.BlogCategory;
import com.in.cafe.domain.BlogUser;
import com.in.cafe.domain.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {
	 List<Post> findByBloguser(BlogUser user);
	 List<Post> findByBlogCategory(BlogCategory category);
	 @Query("select p from Post p WHERE p.title LIKE :key")
	 List<Post> serchPostByKey(@Param("key") String title);
}
