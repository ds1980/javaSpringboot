package com.in.cafe.JWT;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.in.cafe.POJO.User;
import com.in.cafe.utils.JwtUtils;

import io.jsonwebtoken.Claims;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private CustomerUserDetailService service;
	
	Claims claims = null;
	
	private String userName = null;
	private String userId = null;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if(request.getServletPath().matches("/user/login|/user/forgetpassword|/user/signup |/api/v2/user/ |/api/v3/api-docs" )) {
			filterChain.doFilter(request, response);
		} else {
			String authorizationHeader = request.getHeader("Authorization");
			System.out.println("=====authorizationHeader=========");
			System.out.println(authorizationHeader);
			String token = null;
			if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				token = authorizationHeader.substring(7);
				userName = jwtUtils.extractUserName(token);
				claims = jwtUtils.extractsAllClaims(token);
			}
			if(userName !=null  && SecurityContextHolder.getContext().getAuthentication()== null) {
				
				UserDetails userDetails = service.loadUserByUsername(userName);
				if(jwtUtils.validateToken(token, userDetails)) {
					UsernamePasswordAuthenticationToken  usernamePasswordAuthenticationToken =
								new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken.setDetails(
							new WebAuthenticationDetailsSource().buildDetails(request)
							);
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			} else {
			}
			
			filterChain.doFilter(request, response);
		}
		
	}
	
	public boolean isAdmin() {
		return "admin".equalsIgnoreCase((String) claims.get("role"));
	}
	
	public boolean isUser() {
		return "user".equalsIgnoreCase((String) claims.get("role"));
	}
	public String getCurrentUser() {
		
		System.out.println(userName);
		return userName;
	}
	public  int getUserId() {
		System.out.println("==================User Id ==============");
		// claims.get("userId");
		 System.out.println(claims.get("userId"));
		// return userId;
		 return ((int) claims.get("userId"));
	}
	
	
}
