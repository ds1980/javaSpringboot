package com.in.cafe.restImpl;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.in.cafe.POJO.User;
import com.in.cafe.constants.CafeConstants;
import com.in.cafe.rest.UserRest;
import com.in.cafe.service.UserService;
import com.in.cafe.utils.CafeUtils;
import com.in.cafe.wrapper.UserWrapper;

@RestController
public class UserRestImpl implements UserRest {

	@Autowired
	UserService userService;
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		
		// TODO Auto-generated method stub
		try {
			return userService.signUp(requestMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		try {
			return userService.login(requestMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	public ResponseEntity<List<UserWrapper>> getAllusers() {
		return userService.getAllUser();
	
	}
	@Override
	public ResponseEntity<String> updateUser(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		return userService.updateUser(requestMap);
		
	}
	@Override
	public ResponseEntity<String> checkToken() {
		try {
			return userService.checkToken();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	public ResponseEntity<String> changePassword(Map<String, String> requestMap) {
		try {
			return userService.changePassword(requestMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
