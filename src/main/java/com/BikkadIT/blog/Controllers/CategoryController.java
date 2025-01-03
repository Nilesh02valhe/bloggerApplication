package com.BikkadIT.blog.Controllers;

import java.util.List;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.blog.Payloads.ApiResponse;
import com.BikkadIT.blog.Payloads.CategoryDto;
import com.BikkadIT.blog.Services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
		
	@Autowired
	private CategoryService categoryService; 
	
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto createcategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createcategory, HttpStatus.CREATED);

	}

	@PutMapping("/{CatId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable Integer CatId) {
		CategoryDto updatecategory = this.categoryService.updateCategory(categoryDto, CatId);
		return new ResponseEntity<CategoryDto>(updatecategory, HttpStatus.OK);
	}

	@DeleteMapping("/{CatId}")
	public ResponseEntity<ApiResponse> DeleteCategory(@PathVariable Integer CatId) {
		this.categoryService.deleteCategory(CatId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Categories Deleted Successfully", true),
				HttpStatus.OK);
	}
	@GetMapping("/{CatId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer CatId) {
		CategoryDto categoryDto =this.categoryService.getCategory(CatId);
		return new ResponseEntity<CategoryDto> (categoryDto, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		List<CategoryDto> categories = this.categoryService.getCategories();		
		return ResponseEntity.ok(categories);		
	}

}
