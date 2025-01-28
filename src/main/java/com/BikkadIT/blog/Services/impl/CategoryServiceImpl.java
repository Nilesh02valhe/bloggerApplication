package com.BikkadIT.blog.Services.impl;

import com.BikkadIT.blog.Entities.Category;
import com.BikkadIT.blog.Exceptions.ResourceNotFoundException;
import com.BikkadIT.blog.Payloads.CategoryDto;
import com.BikkadIT.blog.Repository.CategoryRepo;
import com.BikkadIT.blog.Services.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.util.*;
import org.springframework.stereotype.Service;
@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		logger.info("Finding category started categoryDto: "+ categoryDto );
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedcat = this.categoryRepo.save(cat);
		return this.modelMapper.map(addedcat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
		.orElseThrow(()-> new ResourceNotFoundException("Catergory", "Category Id", categoryId));
		logger.info("category finding ..."+ categoryId);
		cat.setCategoryTitle(categoryDto.getCategotyTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedcat = this.categoryRepo.save(cat);
//		cat.setCategoryId(categoryDto.getCategoryId());
		logger.info("category finding ..."+ categoryDto);
		return this.modelMapper.map(updatedcat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId)
		.orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
		logger.info("category finding ..."+ categoryId);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
		.orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
//		this.categoryRepo.save(cat);
		logger.info("category finding ..."+ categoryId);
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = this.categoryRepo.findAll();		
		List<CategoryDto> catDtos = categories.stream().map((cat)-> this.modelMapper.
				map(cat, CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
	}

}	