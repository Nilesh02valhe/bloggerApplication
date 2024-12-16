package com.BikkadIT.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.blog.Entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	

}
