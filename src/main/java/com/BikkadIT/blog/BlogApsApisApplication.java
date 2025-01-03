package com.BikkadIT.blog;



import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.spi.LoggerFactory;
import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogApsApisApplication {
	
//	private static final Logger logger = Logger.getLogger(BlogApsApisApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BlogApsApisApplication.class, args);
		
//		Layout layout = new SimpleLayout();
			
	}
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
		
	}

}
