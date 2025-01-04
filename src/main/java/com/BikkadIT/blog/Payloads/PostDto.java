package com.BikkadIT.blog.Payloads;

import java.util.Date;

import com.BikkadIT.blog.Entities.Category;
import com.BikkadIT.blog.Entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private String content;
	
	private String title;
	
	private String imageName;
	
	private Date addedDate;
	

	private CategoryDto category;
	
	private User user;

}
