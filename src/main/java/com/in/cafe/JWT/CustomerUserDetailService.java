package com.in.cafe.JWT;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.in.cafe.dao.UserDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerUserDetailService implements UserDetailsService {

	@Autowired
	UserDao userdao;
	
	private com.in.cafe.POJO.User userDetail;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Inside username {} ", username);
		// TODO Auto-generated method stub
		userDetail = userdao.findByEmailId(username);
		if(!Objects.isNull(userDetail)) 
			return new User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>());
		else 
			throw new UsernameNotFoundException("User not Found");
	}
	
	public  com.in.cafe.POJO.User getUserDetail() {
		return userDetail;
		
	}

}
