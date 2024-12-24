package com.BikkadIT.blog.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.blog.Payloads.ApiResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice

@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourseNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message= ex.getMessage();
		ApiResponse apiResponse= new ApiResponse(message,false);		
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);		
	}
}
