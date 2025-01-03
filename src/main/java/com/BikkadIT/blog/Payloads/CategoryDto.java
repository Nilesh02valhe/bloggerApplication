package com.BikkadIT.blog.Payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer categoryId;
	
	@NotBlank
	@Size(min=4, message="min size of category size is 4")
	private String CategotyTitle;
	
	@NotBlank
	@Size(min=10, message="min size of category desc is 10")
	private String categoryDescription;

}
