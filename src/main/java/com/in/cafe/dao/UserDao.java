package com.in.cafe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in.cafe.POJO.User;
import com.in.cafe.wrapper.UserWrapper;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmailId(@Param("email") String email);
	List<UserWrapper> getAllUsers();
	
	 List<String> getAllAdmin();
	
	@Transactional
	@Modifying
	Integer updateStatus(@Param("status") String status, @Param("id") Integer id);
	
}
