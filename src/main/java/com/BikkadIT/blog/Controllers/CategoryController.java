package com.BikkadIT.blog.Controllers;

import java.util.List;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.apache.log4j.Logger;
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
import com.BikkadIT.blog.Services.impl.UserServiceImpl;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
		
	@Autowired
	private CategoryService categoryService; 
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		logger.info("create category");
		CategoryDto createcategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createcategory, HttpStatus.CREATED);

	}

	@PutMapping("/{CatId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable Integer CatId) {
		logger.info("Update category of categoryID");
		CategoryDto updatecategory = this.categoryService.updateCategory(categoryDto, CatId);
		return new ResponseEntity<CategoryDto>(updatecategory, HttpStatus.OK);
	}

	@DeleteMapping("/{CatId}")
	public ResponseEntity<ApiResponse> DeleteCategory(@PathVariable Integer CatId) {
		logger.info("delete category of categoryID: "+ CatId);
		this.categoryService.deleteCategory(CatId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Categories Deleted Successfully", true),
				HttpStatus.OK);
	}
	@GetMapping("/{CatId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer CatId) {
		logger.info("delete category of categoryID: "+ CatId);
		CategoryDto categoryDto =this.categoryService.getCategory(CatId);
		return new ResponseEntity<CategoryDto> (categoryDto, HttpStatus.OK);
	}
//	getAll
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		logger.info("Get All categories");
		List<CategoryDto> categories = this.categoryService.getCategories();		
		return ResponseEntity.ok(categories);		
	}

}
