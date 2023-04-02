package com.in.cafe.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.in.cafe.POJO.ApiResponse;

public class ResponseUtil {
	
	 ResponseUtil() {
	    }
	 public static ResponseEntity<ApiResponse> getResponse(final HttpStatus statusCode, final String message, final Object result) {
		
		 return ResponseEntity.ok().body(new ApiResponse(statusCode.value(), message, result));
	 }
}
