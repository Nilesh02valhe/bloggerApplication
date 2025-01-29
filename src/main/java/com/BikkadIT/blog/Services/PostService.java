package com.BikkadIT.blog.Services;

import java.util.List;

import com.BikkadIT.blog.Entities.Category;
import com.BikkadIT.blog.Entities.Post;
import com.BikkadIT.blog.Entities.User;
import com.BikkadIT.blog.Payloads.PostDto;

public interface PostService {
	
//	create
	PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
	
//	update
	PostDto updatePost(PostDto postDto, Integer postId);

//	delete
	void deletePost(Integer postId);
	
//	get All Post
	List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);
	 
//	 Get Single Post	
	PostDto getPostById(Integer postId);
	
//	get All Post in Category	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
//	get All post by User	
	List<PostDto> getPostsByUser(Integer userId);
	
//	Serch post
	List<Post> serchPosts(String keyword);

	
	
}
