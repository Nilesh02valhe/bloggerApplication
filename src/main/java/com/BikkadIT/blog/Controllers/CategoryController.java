package com.BikkadIT.blog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.blog.Payloads.CategoryDto;
import com.BikkadIT.blog.Services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
		
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
		
		CategoryDto createcategory = this.categoryService.createCategory(categoryDto);
		
		
		return new ResponseEntity<CategoryDto>(createcategory,HttpStatus.CREATED) ;
		
	}
	@PutMapping("/{CatId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto , @PathVariable Integer CatId){
		
		CategoryDto updatecategory = this.categoryService.updateCategory(categoryDto, CatId);
		
		
		return new ResponseEntity<CategoryDto>(updatecategory,HttpStatus.OK) ;
	}
	
}
