package com.in.cafe.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BlogUserDto {
	private int id;
	
	@NotEmpty
	@Size(min = 4, message="username must be min of 4 characters")
	private String name;
	
	@Email(message="Email address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min=3, max=10, message="Password must be min of 3 characters and maximum 10 characters")
	private String password;
	
	@NotEmpty
	private String about;
}
