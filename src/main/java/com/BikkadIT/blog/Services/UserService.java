 package com.BikkadIT.blog.Services;

import java.util.List;

import com.BikkadIT.blog.Entities.User;
import com.BikkadIT.blog.Payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);

	UserDto UpadateUser(UserDto user, Integer UserId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();
	
	void deleteUser(Integer UserId);
}
