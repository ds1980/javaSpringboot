package com.in.cafe.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.in.cafe.JWT.CustomerUserDetailService;
import com.in.cafe.JWT.JwtFilter;
import com.in.cafe.POJO.TblUserLogin;
import com.in.cafe.POJO.TblUserLoginDto;
import com.in.cafe.POJO.User;
import com.in.cafe.constants.CafeConstants;
import com.in.cafe.dao.UserDao;
import com.in.cafe.service.UserService;
import com.in.cafe.utils.CafeUtils;
import com.in.cafe.utils.EmailUtils;
import com.in.cafe.utils.JwtUtils;
import com.in.cafe.wrapper.UserWrapper;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	CustomerUserDetailService customerUserDetailService;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	JwtFilter jwtFilter;
	
	@Autowired
	EmailUtils emailUtils;
	
	
	
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			if(validateSignUpmap(requestMap)) {
				User user = userDao.findByEmailId(requestMap.get("email"));
				if(Objects.isNull(user)) {
					userDao.save(getUserFromMap(requestMap));
					return CafeUtils.getresponseEntity("Registered Data successfully", HttpStatus.OK);
				} else {
					return CafeUtils.getresponseEntity("Email Already Exist", HttpStatus.BAD_REQUEST);
				}
			} else {
				return CafeUtils.getresponseEntity(CafeConstants.INVALID_DATA,  HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// check validation 
	private Boolean validateSignUpmap(Map<String, String> requestMap) {
		if(requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
			&& requestMap.containsKey("email") && requestMap.containsKey("password"))
		{
			return true;
		} else {
		return false;
		}
	}
	
	// get users
	private User getUserFromMap(Map<String, String> requestMap) {
		System.out.println(requestMap);
		User user = new User();
		user.setName(requestMap.get("name"));
		user.setEmail(requestMap.get("email"));
		user.setContactNumber(requestMap.get("contactNumber"));
		user.setPassword(requestMap.get("password"));
		user.setStatus(requestMap.get("status"));
		user.setRole("user");
		return user;
	}

	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
	
		// TODO Auto-generated method stub
		try {
			Authentication auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("password"))	
					);
			 
				if(auth.isAuthenticated()) {
					if(customerUserDetailService.getUserDetail().getStatus().equalsIgnoreCase("true")) {
						return new ResponseEntity<String>("{\"token\":\"" + jwtUtils.generateToken(customerUserDetailService.getUserDetail().getEmail(), 
								customerUserDetailService.getUserDetail().getId(), customerUserDetailService.getUserDetail().getRole()) + "\"}",
								HttpStatus.OK); 
					}
					else {
						return new ResponseEntity<String>("{\"message\":\""+"Wait for Admin Approval"+ "\"}", 
							HttpStatus.BAD_REQUEST); 
					}
				} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return new ResponseEntity<String>("{\"message\":\""+"Bed Credentials Request"+ "\"}", 
				HttpStatus.BAD_REQUEST); 
	}

	@Override
	public ResponseEntity<List<UserWrapper>> getAllUser() {
		try {
		
			if(jwtFilter.isAdmin()) {
				return new ResponseEntity<>(userDao.getAllUsers(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<List<UserWrapper>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> updateUser(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			
			if(jwtFilter.isAdmin()) {
				 Optional<User> optional =  userDao.findById(Integer.parseInt(requestMap.get("id")));
				if(!optional.isEmpty()) {
					
				// send Email to All Admin users
					
					// sendMailToAllAdmin(requestMap.get("status"), optional.get().getEmail(), userDao.getAllAdmin());
				// update User	
				 userDao.updateStatus(requestMap.get("status"), Integer.parseInt(requestMap.get("id")));
				 	return CafeUtils.getresponseEntity("User Status update Successfully", HttpStatus.OK);
				} else {
					CafeUtils.getresponseEntity("User does not exist", HttpStatus.OK);
				}
			} else {
				CafeUtils.getresponseEntity(CafeConstants.UNAUTHRIZED_ACCESS, HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// send Email
	private void sendMailToAllAdmin(String status, String user, List<String> allAdmin) {
		allAdmin.remove(jwtFilter.getCurrentUser());
		if(status != null && status.equalsIgnoreCase("true")) {
			emailUtils.sendSimpleMessage(jwtFilter.getCurrentUser(), "Account Approved", "USER:- "+user+"\n is approved by \nADMIN:-" +  jwtFilter.getCurrentUser(), allAdmin);
		} else {
			emailUtils.sendSimpleMessage(jwtFilter.getCurrentUser(), "Account disabled", "USER:- "+user+"\n is disabled by \nADMIN:-" +  jwtFilter.getCurrentUser(), allAdmin);
		}
		
	}

	@Override
	public ResponseEntity<String> checkToken() {
		return CafeUtils.getresponseEntity("true", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> changePassword(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			
			User usrObj = userDao.findByEmailId(jwtFilter.getCurrentUser());
			if(!usrObj.equals(null)) {
					if(usrObj.getPassword().equals(requestMap.get("oldPassword"))) {
						usrObj.setPassword(requestMap.get("newPassword"));
						userDao.save(usrObj);
						return CafeUtils.getresponseEntity("Password updated successfully", HttpStatus.OK);
					} else {
						return CafeUtils.getresponseEntity("Incorrect Old Password", HttpStatus.BAD_REQUEST);	
					}
			} else {
				return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public Optional<User> getUserInfo(int id) {
		try {
			return userDao.findById(id);
		} catch (Exception e) {
			
		}
		return Optional.empty();
	}

}
