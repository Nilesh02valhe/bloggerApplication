package com.BikkadIT.blog.Services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
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
//import com.BikkadIT.blog.Services.PostService;


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
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	private Optional<Category> byId;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->
		new ResourceNotFoundException("User", "user id", userId));
		
		logger.info("Finding post started userDto: "+ postDto );

		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->
		new ResourceNotFoundException("Category", "Category id", categoryId));
		logger.info("categoryId finding ..."+ categoryId);
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
	public PostDto getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).
				orElseThrow(()-> new ResourceNotFoundException("category","category Id", categoryId));
	List<Post> posts= this.postRepo.findBycategory(cat);
	logger.info("categoryId finding ..."+ categoryId);
	List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}
	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		
		 User user = this.userRepo.findById(userId).orElseThrow(()->
		 new ResourceNotFoundException("User", "userId", userId));	
		logger.info("userId finding ..."+ userId);
		List<Post> posts = this.postRepo.findByUser(user);
		List<PostDto> PostDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return PostDtos;
	}
	@Override
	public List<Post> serchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPost() {
		List<Post> allPosts = this.postRepo.findAll();
		return null;
	}
}


