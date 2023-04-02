package com.in.cafe.wrapper;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserWrapper  implements Serializable  {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String email;
	private String contactNumber;
	private String status;
	
	public UserWrapper(int id, String name, String email, String contactNumber, String status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNumber = contactNumber;
		this.status = status;
	}

	
}
