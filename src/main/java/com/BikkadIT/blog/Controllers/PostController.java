package com.BikkadIT.blog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
		PostDto createpost = this.postService.createPost(postDto, userId, categoryId);
		
		return new ResponseEntity<PostDto>(createpost, HttpStatus.CREATED);
		
	}

}
