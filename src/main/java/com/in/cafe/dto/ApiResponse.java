package com.in.cafe.dto;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse{
	/** The Constant serialVersionUID. */
	private String message;
	private boolean status;
	
	
}
