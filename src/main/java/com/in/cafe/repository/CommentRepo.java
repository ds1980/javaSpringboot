package com.in.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.cafe.domain.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
