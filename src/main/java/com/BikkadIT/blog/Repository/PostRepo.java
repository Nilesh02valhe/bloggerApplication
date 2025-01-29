package com.BikkadIT.blog.Repository;

import java.awt.print.Pageable;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.blog.Entities.Category;
import com.BikkadIT.blog.Entities.Post;
import com.BikkadIT.blog.Entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findBycategory(Category category);
	
	List<Post> findByUser(User user);
	
	List<Post> findByTitleContaining(String title);

	

}
