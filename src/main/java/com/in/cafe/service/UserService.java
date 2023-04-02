package com.in.cafe.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.in.cafe.POJO.TblUserLogin;
import com.in.cafe.POJO.TblUserLoginDto;
import com.in.cafe.POJO.User;
import com.in.cafe.domain.TblCountry;
import com.in.cafe.wrapper.UserWrapper;

public interface UserService {
	ResponseEntity<String> signUp(Map<String, String> requestMap);

	ResponseEntity<String> login(Map<String, String> requestMap);

	ResponseEntity<List<UserWrapper>> getAllUser();

	ResponseEntity<String> updateUser(Map<String, String> requestMap);
	
	Optional<User> getUserInfo(int id);

	ResponseEntity<String> checkToken();

	ResponseEntity<String> changePassword(Map<String, String> requestMap);

}
