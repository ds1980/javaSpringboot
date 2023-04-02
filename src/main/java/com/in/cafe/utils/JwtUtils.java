package com.in.cafe.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.in.cafe.POJO.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtils {

	private String secret = "thisissecretkey";
	public String extractUserName(String token) {
		return ExtractClaims(token, Claims::getSubject);
	}
	
	public Date extractDateExpiration(String token) {
		return ExtractClaims(token, Claims::getExpiration);
	}
	public String extractuserId(String token) {
		return ExtractClaims(token, Claims::getId);
	}
	
	public <T> T ExtractClaims(String token, Function<Claims, T> ClaimsResolver) {
		final Claims claims = extractsAllClaims(token);
		return ClaimsResolver.apply(claims);
	}
	
	
	public Claims extractsAllClaims (String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	public Boolean isTokenExpired(String token) {
		return extractDateExpiration(token).before(new Date());
	}
	public String generateToken(String username, int userId, String role) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("role", role);
		claims.put("userId", userId);
		return createToken(claims, username);			
	}
	private String createToken(Map<String, Object> claims, String subject) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, secret).compact();
				
		// ten hours calculation 
	}
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String userName = extractUserName(token);
		return(userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
