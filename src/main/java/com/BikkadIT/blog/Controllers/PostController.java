package com.BikkadIT.blog.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.blog.Entities.Post;
import com.BikkadIT.blog.Payloads.PostDto;
import com.BikkadIT.blog.Services.PostService;

@RestController
@RequestMapping("/apis/")
public class PostController {
	
	@Autowired
	private PostService postService; 
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(
			@RequestBody PostDto postDto,
			@PathVariable Integer userId, 
			@PathVariable Integer categoryId){
		PostDto createpost = this.postService.createPost(postDto, userId, categoryId);
		
		return new ResponseEntity<PostDto>(createpost, HttpStatus.CREATED);
		
	}
	
//	get By User
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(
			@PathVariable Integer userId){
		
		List<PostDto> posts = this.postService.getPostsByUser(userId);
		
		
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK) ;
		
	}

	
//	get By Category
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(
			@PathVariable Integer categoryId){
		
		List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
		
		
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK) ;
		
	}
}
