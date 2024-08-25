package com.nath.car_rental.dto;

import com.nath.car_rental.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {
	
private Long id;
	
	private String name;
	
	private String email;
		
	private UserRole role;

}
