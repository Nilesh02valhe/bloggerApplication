package com.BikkadIT.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogApsApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApsApisApplication.class, args);
			
	}
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
		
	}

}
