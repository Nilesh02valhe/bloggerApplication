package com.BikkadIT.blog.Controllers;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.blog.Payloads.ApiResponse;
import com.BikkadIT.blog.Payloads.UserDto;
import com.BikkadIT.blog.Services.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
//	post====create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid  @RequestBody UserDto userDto ){
		logger.info("create User");
		UserDto createUserDto = this.userService.createUser(userDto);		
		System.out.println("Input Data: " + userDto);
		return new ResponseEntity<UserDto>(createUserDto,HttpStatus.CREATED);

		
	}
//	put====Update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> UpdateUser(@Valid @RequestBody UserDto userDto,
			@PathVariable("userId") Integer uid){
		logger.info("Update User: "+uid);
		UserDto updateUser = this.userService.UpadateUser(userDto, uid);
		return ResponseEntity.ok(updateUser);

	}

		
//	delete ==== delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> DeleteUser(@PathVariable("userId") Integer uid ){
		logger.info("Delete User: "+uid);
		this.userService.deleteUser(uid);
		return new  ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true),HttpStatus.OK);
		
	}
//	get === user get
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		logger.info("Get User");
		return ResponseEntity.ok(this.userService.getAllUsers());
		
	}
//	get Single user
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingle(@PathVariable Integer userId){
		logger.info("Single User");
		return ResponseEntity.ok(this.userService.getUserById(userId));		
	}
	
}


