package com.BikkadIT.blog.Services;

import java.util.List;

import com.BikkadIT.blog.Entities.Category;
import com.BikkadIT.blog.Payloads.CategoryDto;

public interface CategoryService {
	
//	create
	CategoryDto createCategory(CategoryDto categoryDto);
	
//	update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
//	delete
	void deleteCategory(Integer categoryId);
	
//	get
	CategoryDto getCategory (Integer categoryId);
	
//	Get All
	List<CategoryDto> getCategories();
	
}
