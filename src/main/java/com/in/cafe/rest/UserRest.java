package com.in.cafe.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.in.cafe.POJO.User;
import com.in.cafe.wrapper.UserWrapper;



@RequestMapping(path="/user")
public interface UserRest {
	@PostMapping(path="/signup")
	public ResponseEntity<String> signUp( @RequestBody(required =true)Map<String, String>requestMap);
	
	@PostMapping(path="/login")
	public ResponseEntity<String> login(@RequestBody(required=true) Map<String, String> requestMap);
	
	@GetMapping(path="/get")
	public ResponseEntity<List<UserWrapper>> getAllusers();
	
	
	@PostMapping(path="/update")
	public ResponseEntity<String> updateUser( @RequestBody(required=true) Map<String, String> requestMap);
	
	@GetMapping(path="/token")
	public ResponseEntity<String> checkToken();
	
	@PostMapping(path="/changepassword")
	ResponseEntity<String> changePassword(@RequestBody(required=true) Map<String, String> requestMap);
	
}
