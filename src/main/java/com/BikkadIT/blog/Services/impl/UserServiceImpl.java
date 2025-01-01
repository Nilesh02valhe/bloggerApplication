package com.BikkadIT.blog.Services.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.blog.BlogApsApisApplication;
import com.BikkadIT.blog.Entities.User;
import com.BikkadIT.blog.Payloads.UserDto;
import com.BikkadIT.blog.Repository.UserRepo;
import com.BikkadIT.blog.Services.UserService;

import lombok.extern.slf4j.Slf4j;

import com.BikkadIT.blog.Exceptions.*;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public UserDto createUser(UserDto userDto) {		
		logger.info("Finding post started userDto: "+ userDto);
		
		User user= this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		logger.info("Posted finding ..."+ userDto);
		
		return this.userToDto(savedUser);	
	}
	@Override
	public UserDto UpadateUser(UserDto userDto, Integer UserId) {
		User user = this.userRepo.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User","id",UserId));
		logger.info("To Check the update UserId: "+ UserId);
		user.setName(userDto.getName());	
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
//		user.setId(userDto.getId());
		logger.info("To Complete requist UserId: "+ UserId);
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;
		
	}
	@Override
	public UserDto getUserById(Integer userId) {
		
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		 log.error("User not found with Id: {}", userId);
		return this.userToDto(user);		
	}
	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user ->this.userToDto(user)).collect(Collectors.toList());
		log.error("Get all record are found: {}");
		return userDtos;
	}
	@Override
	public void deleteUser(Integer UserId) {
		User user = this.userRepo.findById(UserId)
		.orElseThrow(() -> new ResourceNotFoundException("User","Id",UserId));
		log.error("delete by single record: {}"+ UserId);
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
