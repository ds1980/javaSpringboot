package com.in.cafe.exceptions;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String resourcename;
	String fieldName;
	long fieldValue;
	
	public ResourceNotFoundException(String respourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s", respourceName, fieldName, fieldValue));
		this.resourcename = respourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
