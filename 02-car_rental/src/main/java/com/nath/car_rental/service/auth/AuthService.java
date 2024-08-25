package com.nath.car_rental.service.auth;

import com.nath.car_rental.dto.SignupRequest;
import com.nath.car_rental.dto.UserDto;

public interface AuthService {
	
	UserDto createUser(SignupRequest signupRequest);
	
	public boolean hasCustomerWithEmail(String email);

}
