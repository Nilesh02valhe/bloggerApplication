package com.BikkadIT.blog.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private int categoryId;
	
	private String CategotyTitle;
	
	private String categoryDescription;

}
