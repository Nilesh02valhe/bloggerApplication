package com.BikkadIT.blog.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.BikkadIT.blog.Entities.User;
import com.BikkadIT.blog.Payloads.UserDto;
import com.BikkadIT.blog.Repository.UserRepo;
import com.BikkadIT.blog.Services.UserService;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user= this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
		
	}

	@Override
	public UserDto UpadateUser(UserDto user, Integer UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(UserDto userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer UserId) {
		// TODO Auto-generated method stub
		
	}
	
	private User dtoToUser(UserDto userDto) {
		
		User user= new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(user.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(user.getAbout());
		return user;
		
	}
	
	public UserDto userToDto(User user){
		UserDto userDto= new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		return userDto;		
	}
	

}
