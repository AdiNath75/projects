package com.nath.car_rental.service.auth;

import org.springframework.stereotype.Service;

import com.nath.car_rental.dto.SignupRequest;
import com.nath.car_rental.dto.UserDto;
import com.nath.car_rental.entity.User;
import com.nath.car_rental.enums.UserRole;
import com.nath.car_rental.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
	
	private final UserRepository userRepository;

	@Override
	public UserDto createUser(SignupRequest signupRequest) {
		User user = new User();
		user.setName(signupRequest.getName());
		user.setEmail(signupRequest.getEmail());
		user.setPassword(signupRequest.getPassword());
		user.setRole(UserRole.CUSTOMER);
		User createUser = userRepository.save(user);
		UserDto userDto = new UserDto();
		userDto.setId(createUser.getId());
		return userDto;
	}

	@Override
	public boolean hasCustomerWithEmail(String email) {
		return userRepository.findFirstByEmail(email).isPresent();
	}

}
