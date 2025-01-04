package com.BikkadIT.blog.Services.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.blog.Entities.Category;
import com.BikkadIT.blog.Entities.Post;
import com.BikkadIT.blog.Entities.User;
import com.BikkadIT.blog.Exceptions.ResourceNotFoundException;
import com.BikkadIT.blog.Payloads.PostDto;
import com.BikkadIT.blog.Repository.CategoryRepo;
import com.BikkadIT.blog.Repository.PostRepo;
import com.BikkadIT.blog.Repository.UserRepo;
import com.BikkadIT.blog.Services.PostService;


@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;


	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->
		new ResourceNotFoundException("User", "user id", userId));

		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->
		new ResourceNotFoundException("Category", "Category id", categoryId));
			
			Post post = this.modelMapper.map(postDto, Post.class);
			post.setImagename("default.png");
			post.setAddedDate(new Date());
			post.setUser(user);
			post.setCategory(category);
			Post newPost = this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Category> getPostsByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getPostsByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> serchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}



}


