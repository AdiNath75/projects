package com.nath.car_rental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nath.car_rental.dto.SignupRequest;
import com.nath.car_rental.dto.UserDto;
import com.nath.car_rental.service.auth.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest){
		
		if(authService.hasCustomerWithEmail(signupRequest.getEmail())) {
			return new ResponseEntity<>("Customer alresy exist", HttpStatus.NOT_ACCEPTABLE);
		}
		
		UserDto createdCustomerDto = authService.createUser(signupRequest);
		if(createdCustomerDto == null) return new ResponseEntity<> ("Customer entry nopt created, Come again later",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(createdCustomerDto,HttpStatus.CREATED);
	}

}
