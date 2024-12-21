package com.BikkadIT.blog.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Users")
@NoArgsConstructor  //if we are use in generete by constructor at that time we use in this annotation
@Getter
@Setter
public class User {
		
	@Id  // to generate primary key
	@GeneratedValue(strategy= GenerationType.AUTO)
	
	private int id;
	
	@Column (name="User_name", nullable = false, length = 100)// using for to change column name
	private String name;

	private String email;
	
	private String password;

	private String about;

}	
