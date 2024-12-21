package com.BikkadIT.blog.Services.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.blog.Entities.User;
import com.BikkadIT.blog.Payloads.UserDto;
import com.BikkadIT.blog.Repository.UserRepo;
import com.BikkadIT.blog.Services.UserService;
import com.BikkadIT.blog.Exceptions.*;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user= this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);		
	}
	@Override
	public UserDto UpadateUser(UserDto userDto, Integer UserId) {
		User user = this.userRepo.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User","id",UserId));
		user.setName(userDto.getName());	
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
//		user.setId(userDto.getId());
		
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;	
	}
	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
	
		return this.userToDto(user);		
	}
	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user ->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}
	@Override
	public void deleteUser(Integer UserId) {
		User user = this.userRepo.findById(UserId)
		.orElseThrow(() -> new ResourceNotFoundException("User","id",UserId));
		
	}	
	public User dtoToUser(UserDto userDto) {	
		User user=this.modelmapper.map(userDto, User.class);
//		User user= new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return user;		
	}	
	public UserDto userToDto(User user){
		UserDto userDto= this.modelmapper.map(user, UserDto.class);
//		UserDto userDto= new UserDto();	
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		return userDto;		
	}	
}
